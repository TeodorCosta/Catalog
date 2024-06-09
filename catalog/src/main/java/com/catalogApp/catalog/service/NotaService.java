package com.catalogApp.catalog.service;

import com.catalogApp.catalog.entity.Nota;
import com.catalogApp.catalog.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NotaService {

    @Autowired
    NotaRepository notaRepository;

    public void saveNota(Nota nota){
        notaRepository.save(nota);
    }


}
