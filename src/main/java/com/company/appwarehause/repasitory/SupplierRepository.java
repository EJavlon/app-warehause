package com.company.appwarehause.repasitory;

import com.company.appwarehause.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
}
