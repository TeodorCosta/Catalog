package com.catalogApp.catalog.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
@ToString
public class ProgramStudiu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean licenta;

    private String facultate;

    private Integer durata;

    private String nume;




}
