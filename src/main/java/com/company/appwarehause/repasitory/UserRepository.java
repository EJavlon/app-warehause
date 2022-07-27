package com.company.appwarehause.repasitory;

import com.company.appwarehause.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByPhoneNumber(String phoneNumber);

    @Query(value = "select count(* from ",nativeQuery = true)
    long countAllUser();
}
