package com.example.Mgnrega.Service;

import com.example.Mgnrega.DTO.Recordsdto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class Recordsservice {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Redisservice redisservice;

    @Autowired
    private Postgreservice postgreservice;

    public List<Recordsdto> getMgnregaData(String districtName) {
        System.out.println("Processing request for: " + districtName);

        // fetching Redis first
        List<Recordsdto> records = redisservice.getRecords(districtName);

        if (records != null && !records.isEmpty()) {
            System.out.println("giving from Redis cache");
            return records;
        }

        //  if Redis empty, move to db
        else {
            records = postgreservice.getrecordsbydistrict(districtName);

            if (!records.isEmpty()) {
                //Store in Redis for 8 hours  validity
                redisservice.storeRecords(districtName, records);
                System.out.println("giving from database & cached in Redis for 8 hours");
                return records;
            }
        }

        return records;
    }

    public List<Recordsdto> getmgnregadata(String stateName) {
        try {
            String apiUrl = "https://api.data.gov.in/resource/ee03643a-ee4c-48c2-ac30-9f2ff26ab722"
                    + "?api-key=579b464db66ec23bdd0000014ec94774ed4e431551f8753b3d90c14a"
                    + "&format=json"
                    + "&limit=100"
                    + "&offset=0"
                    + "&filters[state_name]=" + stateName;

            // Call external API
            String rawjson = restTemplate.getForObject(apiUrl, String.class);

            // Extract records from raw JSON
            JsonNode rootnode = objectMapper.readTree(rawjson);
            JsonNode recordsnode = rootnode.get("records");

            // Convert JSON array → List<Recordsdto>
            List<Recordsdto> records = objectMapper.readValue(
                    recordsnode.toString(),
                    new TypeReference<List<Recordsdto>>() {}
            );

            System.out.println("Fetched " + records.size() + " records from Government API");

          //storing in db
            postgreservice.storeRecords(records);
            System.out.println("Data stored in database only");

            return records;

        } catch (Exception e) {
            System.err.println("Government API failed: " + e.getMessage());
            throw new RuntimeException("Cannot fetch data from any source");
        }
    }
}