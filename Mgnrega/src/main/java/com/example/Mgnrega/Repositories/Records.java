package com.example.Mgnrega.Repositories;

import com.example.Mgnrega.Entities.Recordsentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Records extends JpaRepository<Recordsentity, Long> {

    // Add this method
    List<Recordsentity> findByDistrictName(String districtName);

    // For state-level data fetching
    List<Recordsentity> findByStateName(String stateName);
}