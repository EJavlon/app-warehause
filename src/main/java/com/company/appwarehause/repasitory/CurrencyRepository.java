package com.company.appwarehause.repasitory;

import com.company.appwarehause.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Integer> {

    boolean existsByName(String name);
}
