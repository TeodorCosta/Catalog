package com.catalogApp.catalog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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
}
