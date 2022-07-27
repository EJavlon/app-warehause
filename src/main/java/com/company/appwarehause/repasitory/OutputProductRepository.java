package com.company.appwarehause.repasitory;

import com.company.appwarehause.entity.OutputProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutputProductRepository extends JpaRepository<OutputProduct,Integer> {
}
