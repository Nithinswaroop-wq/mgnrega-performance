package com.example.Mgnrega.Service;

import com.example.Mgnrega.DTO.Recordsdto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class Redisservice {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    // Store in Redis
    public void storeRecords(String stateName, List<Recordsdto> records) {
        String key = "mgnrega:" + stateName.toLowerCase();
        redisTemplate.opsForValue().set(key, records, 8, TimeUnit.HOURS);
        System.out.println("Stored " + records.size() + " records in Redis");
    }

    // Get from Redis - FIXED VERSION
    public List<Recordsdto> getRecords(String stateName) {
        String key = "mgnrega:" + stateName.toLowerCase();

        try {
            Object data = redisTemplate.opsForValue().get(key);

            if (data == null) {
                System.out.println("No records in Redis");
                return null;
            }

            // Convert LinkedHashMap to Recordsdto
            List<Recordsdto> records = objectMapper.convertValue(data,
                    new TypeReference<List<Recordsdto>>() {});

            System.out.println("Found " + records.size() + " records in Redis");
            return records;

        } catch (Exception e) {
            System.out.println("Error reading from Redis: " + e.getMessage());
            return null;
        }
    }
}