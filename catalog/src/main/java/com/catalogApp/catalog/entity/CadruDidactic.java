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

public class CadruDidactic {
    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;

    private String nume;

    private String prenume;

    private String marca;

    private String titlu;

    private String post;


    public String fullName(){
        return this.titlu + ". " + this.nume + " " + this.prenume;
    }

}
