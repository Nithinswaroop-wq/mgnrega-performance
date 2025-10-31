package com.example.Mgnrega.Controller;

import com.example.Mgnrega.DTO.LocationRequest;
import com.example.Mgnrega.DTO.PerformanceData;
import com.example.Mgnrega.DTO.Recordsdto;
import com.example.Mgnrega.Service.Recordsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MgnregaController {

    @Autowired
    private Recordsservice recordsservice;

    @PostMapping("/detect-district")
    public PerformanceData detectDistrict(@RequestBody LocationRequest request) {
        String district = detectDistrictFromCoordinates(request.getLatitude(), request.getLongitude());
        return getPerformance(district);
    }

    @GetMapping("/performance/{district}")
    public PerformanceData getPerformance(@PathVariable String district) {
        List<Recordsdto> records = recordsservice.getMgnregaData(district);

        Recordsdto latest = null;

        for (Recordsdto r : records) {
            if (r.getDistrictName() != null && r.getDistrictName().equalsIgnoreCase(district)) {
                // ✅ FIX: Compare timestamps to find actual latest record
                if (latest == null || r.getCreatedAt().isAfter(latest.getCreatedAt())) {
                    latest = r;
                }
            }
        }

        if (latest != null) {
            return convertToPerformanceData(latest);
        } else {
            return null;
        }
    }

    // Simple location detection
    private String detectDistrictFromCoordinates(double lat, double lng) {
        if (lat >= 26.8 && lat <= 26.9 && lng >= 80.9 && lng <= 81.0) return "LUCKNOW";
        if (lat >= 26.4 && lat <= 26.5 && lng >= 80.3 && lng <= 80.4) return "KANPUR NAGAR";
        if (lat >= 28.6 && lat <= 28.7 && lng >= 77.3 && lng <= 77.4) return "GHAZIABAD";
        if (lat >= 25.3 && lat <= 25.4 && lng >= 82.9 && lng <= 83.0) return "VARANASI";
        if (lat >= 27.1 && lat <= 27.2 && lng >= 77.9 && lng <= 78.0) return "AGRA";
        if (lat >= 25.40 && lat <= 25.50 && lng >= 81.80 && lng <= 81.90) return "ALLAHABAD";
        if (lat >= 28.90 && lat <= 29.00 && lng >= 77.60 && lng <= 77.70) return "MEERUT";
        if (lat >= 26.70 && lat <= 26.80 && lng >= 83.30 && lng <= 83.40) return "GORAKHPUR";
        if (lat >= 27.80 && lat <= 27.90 && lng >= 78.00 && lng <= 78.10) return "ALIGARH";
        if (lat >= 28.30 && lat <= 28.40 && lng >= 79.40 && lng <= 79.50) return "BAREILLY";
        if (lat >= 28.80 && lat <= 28.90 && lng >= 78.70 && lng <= 78.80) return "MORADABAD";
        if (lat >= 29.90 && lat <= 30.00 && lng >= 77.50 && lng <= 77.60) return "SAHARANPUR";
        if (lat >= 25.40 && lat <= 25.50 && lng >= 78.50 && lng <= 78.60) return "JHANSI";
        if (lat >= 27.40 && lat <= 27.50 && lng >= 77.60 && lng <= 77.70) return "MATHURA";
        if (lat >= 27.50 && lat <= 27.60 && lng >= 80.60 && lng <= 80.70) return "SITAPUR";
        if (lat >= 27.50 && lat <= 27.60 && lng >= 81.50 && lng <= 81.60) return "BAHRAICH";
        if (lat >= 26.20 && lat <= 26.30 && lng >= 82.00 && lng <= 82.10) return "SULTANPUR";
        if (lat >= 26.90 && lat <= 27.00 && lng >= 81.10 && lng <= 81.20) return "BARABANKI";

        return "LUCKNOW";
    }

    private PerformanceData convertToPerformanceData(Recordsdto record) {
        PerformanceData data = new PerformanceData();
        data.setDistrict(record.getDistrictName());
        data.setJobCardsIssued(getStringValue(record.getTotalNoOfJobCardsIssued()));
        data.setTotalWorkers(getStringValue(record.getTotalNoOfWorkers()));
        data.setActiveWorkers(getStringValue(record.getTotalNoOfActiveWorkers()));
        data.setApprovedLabourBudget(getStringValue(record.getApprovedLabourBudget()));
        data.setPersonDays(getStringValue(record.getPersondaysOfCentralLiabilitySoFar()));
        data.setWomenWorkers(getStringValue(record.getWomenPersondays()) + " days");
        data.setCompletedWorks(getStringValue(record.getNumberOfCompletedWorks()));
        data.setOngoingWorks(getStringValue(record.getNumberOfOngoingWorks()));
        return data;
    }

    private String getStringValue(Double number) {
        if (number == null) return "0";
        return String.valueOf(number.longValue());
    }
}