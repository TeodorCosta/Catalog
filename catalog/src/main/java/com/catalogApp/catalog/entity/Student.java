package com.catalogApp.catalog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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

    @OneToMany(mappedBy = "student")
    private List<Nota> discipline;

    @ManyToOne
    private ProgramStudiu programStudiu;

    public String fullName(){
        return this.nume +" "+ this.iniT + ". " + this.prenume;
    }

    public float calculateGPAForYear(Student student, int year) {
        List<Nota> grades = student.getDiscipline();
        int totalCredits = 0;
        float weightedSum = 0.0f;

        for (Nota nota : grades) {
            if (nota.getDisciplina().getAn() == year) { // Check if the course is in the given year
                float grade = nota.getValoare();
                int credits = nota.getDisciplina().getCredite();
                weightedSum += grade * credits;
                totalCredits += credits;
            }
        }

        if (totalCredits == 60) { // Ensure the total credits are 60
            return weightedSum / totalCredits;
        }
        else return 0;
    }

}
