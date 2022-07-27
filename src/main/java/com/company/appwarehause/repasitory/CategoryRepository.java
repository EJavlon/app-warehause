package com.company.appwarehause.repasitory;

import com.company.appwarehause.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    boolean existsByName(String name);

    boolean existsByParentCategory(Category parentCategory);
}
