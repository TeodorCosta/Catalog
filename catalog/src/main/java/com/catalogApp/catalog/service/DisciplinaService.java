package com.catalogApp.catalog.service;


import com.catalogApp.catalog.entity.Disciplina;
import com.catalogApp.catalog.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public void saveDisciplina(Disciplina disciplina){

        disciplinaRepository.save(disciplina);
    }
    public List<Disciplina> getDiscipline(){
        return disciplinaRepository.findAll();
    }

}





