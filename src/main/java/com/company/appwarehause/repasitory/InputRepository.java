package com.company.appwarehause.repasitory;

import com.company.appwarehause.entity.Input;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InputRepository extends JpaRepository<Input,Integer> {
    @Query(value = "select count(*) from input",nativeQuery = true)
    long countAllInput();
}
