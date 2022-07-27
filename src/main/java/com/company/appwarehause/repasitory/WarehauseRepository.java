package com.company.appwarehause.repasitory;

import com.company.appwarehause.entity.Warehause;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehauseRepository extends JpaRepository<Warehause,Integer> {
    boolean existsByName(String name);
}
