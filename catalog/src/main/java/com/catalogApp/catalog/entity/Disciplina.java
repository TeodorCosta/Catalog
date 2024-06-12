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
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String codulDisciplinei;
    private String materie;

    private String acronim;

    private Integer credite;

    private Integer an;



    @ManyToOne
    private ProgramStudiu programStudiu;

    private Integer semestru;
}
