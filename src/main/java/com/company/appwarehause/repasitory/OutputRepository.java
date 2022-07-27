package com.company.appwarehause.repasitory;

import com.company.appwarehause.entity.Output;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OutputRepository extends JpaRepository<Output,Integer> {
    @Query(value = "select count(*) from output",nativeQuery = true)
    long countAllOutput();
}
