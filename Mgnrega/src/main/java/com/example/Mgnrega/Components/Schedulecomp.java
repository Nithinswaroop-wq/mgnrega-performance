package com.example.Mgnrega.Components;

import com.example.Mgnrega.Service.Recordsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedulecomp {
    @Autowired
    private Recordsservice recordsservice;
    // Run every 6 hours to keep data fresh (more frequent than Redis expiry)
    @Scheduled(fixedRate =  24 * 60 * 60 * 1000) //for every 24 hrs
    public void updatedatafromgov() {
        System.out.println(" Scheduled refresh from Government API...");

        try {
            // Always get fresh data from government and store in Redis (18hrs) + Oracle
            recordsservice.getmgnregadata("UTTAR PRADESH");
            System.out.println("Scheduled refresh completed");

        } catch (Exception e) {
            System.err.println("Scheduled refresh failed: " + e.getMessage());
            // No problem - existing data in Redis/Oracle will continue to serve users
        }
    }
}
