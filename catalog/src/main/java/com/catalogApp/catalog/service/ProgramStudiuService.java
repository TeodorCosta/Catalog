package com.catalogApp.catalog.service;

import com.catalogApp.catalog.entity.ProgramStudiu;
import com.catalogApp.catalog.repository.ProgramStudiuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramStudiuService {

    @Autowired
    ProgramStudiuRepository programStudiuRepository;

    public List<ProgramStudiu> getProgrameStudiu(){
        return programStudiuRepository.findAll();
    }

    public void saveProgramStudiu(ProgramStudiu programStudiu){
        programStudiuRepository.save(programStudiu);
    }
}
