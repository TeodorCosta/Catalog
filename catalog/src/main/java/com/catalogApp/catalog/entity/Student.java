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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    private String nrMatricol;

    private String nume;

    private String prenume;

    private String iniT;

    private String CNP;

    private LocalDate dataInscriere;

    private String ciclu;

    private Float medieDeIntrare;

    private Integer an;

    public String grupa;

    @ManyToOne
    private ProgramStudiu programStudiu;

    public String fullName(){
        return this.nume +" "+ this.iniT + ". " + this.prenume;
    }

}
