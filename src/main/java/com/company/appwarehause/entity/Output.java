package com.company.appwarehause.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Output {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp timestamp;

    @ManyToOne
    private Warehause warehause;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Currency curruncy;

    private String facuturNumber;

    @Column(unique = true,nullable = false)
    private String code;
}
