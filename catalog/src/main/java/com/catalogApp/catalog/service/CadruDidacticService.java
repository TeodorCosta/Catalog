package com.catalogApp.catalog.service;


import com.catalogApp.catalog.entity.CadruDidactic;
import com.catalogApp.catalog.entity.Student;
import com.catalogApp.catalog.repository.CadruDidacticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class CadruDidacticService {

    @Autowired
    CadruDidacticRepository cadruDidacticRepository;
    public void saveCadruDidactic(CadruDidactic cadruDidactic) {

        cadruDidacticRepository.save(cadruDidactic);

    }

    public List<CadruDidactic> getcadreDidactice() {

        return cadruDidacticRepository.findAll();

    }

    public void delete_cadruDidactic(UUID id){
        cadruDidacticRepository.deleteById(id);
    }

    public CadruDidactic getCadruDidacticById(UUID id){
        return cadruDidacticRepository.getReferenceById(id);

    }
}
