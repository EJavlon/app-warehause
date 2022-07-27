package com.company.appwarehause.entity;

import com.company.appwarehause.entity.template.AbsEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Currency extends AbsEntity {
}
