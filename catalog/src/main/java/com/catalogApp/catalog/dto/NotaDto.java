package com.catalogApp.catalog.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NotaDto {


    private Integer id;

    private String disciplina_id;

    private String student_id;

    private float valoare;



}
