package com.company.appwarehause.repasitory;

import com.company.appwarehause.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepasitory extends JpaRepository<Measurement,Integer> {
    boolean existsByName(String name);
}
