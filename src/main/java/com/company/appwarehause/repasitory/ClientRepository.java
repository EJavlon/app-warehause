package com.company.appwarehause.repasitory;

import com.company.appwarehause.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
    boolean existsByNameAndPhoneNumber(String name, String phoneNumber);
}
