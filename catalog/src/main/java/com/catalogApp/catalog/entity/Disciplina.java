package com.catalogApp.catalog.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;
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



    @OneToMany(mappedBy = "disciplina")
    private List<Nota> studenti;

    @ManyToOne
    private ProgramStudiu programStudiu;

    @ManyToOne
    @JoinColumn(name="cadruDidactic_id")
    private CadruDidactic cadruDidactic;

    private Integer semestru;
}
