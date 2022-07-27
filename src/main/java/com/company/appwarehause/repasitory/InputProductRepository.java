package com.company.appwarehause.repasitory;

import com.company.appwarehause.entity.InputProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputProductRepository extends JpaRepository<InputProduct,Integer> {
}
