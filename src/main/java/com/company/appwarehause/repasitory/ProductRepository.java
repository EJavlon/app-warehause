package com.company.appwarehause.repasitory;

import com.company.appwarehause.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

//    @Query(value = "select (select count(*) from product p where p.name=?1 and p.category_id=?2)>0",nativeQuery = true)
//    boolean existsByNameAndCategoryId(String name, Integer category_id);
    boolean existsByNameAndCategoryId(String name, Integer category_id);

    @Query(value = "select count(*) from prodcut",nativeQuery = true)
    long countAllProduct();


}
