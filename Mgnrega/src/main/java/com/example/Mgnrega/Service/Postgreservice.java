package com.example.Mgnrega.Service;

import com.example.Mgnrega.DTO.Recordsdto;
import com.example.Mgnrega.Entities.Recordsentity;
import com.example.Mgnrega.Repositories.Records;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Postgreservice {

    @Autowired
    private Records repo;

    @Autowired
    private ModelMapper modelMapper;

    // Store all records into Oracle DB
    public void storeRecords(List<Recordsdto> records) {
        if (records == null || records.isEmpty()) {
            System.out.println("No records to store");
            return;
        }
        else {


            List<Recordsentity> entities = new ArrayList<>();
            for (Recordsdto dto : records) {
                if (dto != null) {
                    Recordsentity entity = modelMapper.map(dto, Recordsentity.class);
                    entities.add(entity);
                }
            }

            repo.saveAll(entities);
            System.out.println("Added " + entities.size() + " records to database");
        }
    }



    // Get all records for a specific district
    public List<Recordsdto> getrecordsbydistrict(String districtName) {
        List<Recordsentity> entities = repo.findByDistrictName(districtName);
        List<Recordsdto> records = new ArrayList<>();

        for (Recordsentity entity : entities) {
            Recordsdto dto = modelMapper.map(entity, Recordsdto.class);
            records.add(dto);
        }


        return records;
    }


}