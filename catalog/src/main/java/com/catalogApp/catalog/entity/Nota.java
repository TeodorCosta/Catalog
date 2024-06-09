package com.catalogApp.catalog.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"id"})
})
@ToString
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="disciplina_id")
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    private float valoare;



}
