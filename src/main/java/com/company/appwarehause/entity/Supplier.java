package com.company.appwarehause.entity;

import com.company.appwarehause.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Supplier extends AbsEntity {
    @Column(unique = true,nullable = false)
    private String phoneNumber;
}
