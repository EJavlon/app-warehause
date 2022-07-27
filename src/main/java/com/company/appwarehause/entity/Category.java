package com.company.appwarehause.entity;

import com.company.appwarehause.entity.template.AbsEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Category extends AbsEntity {
    @ManyToOne
    private Category parentCategory;

}
