package com.catalogApp.catalog.service;


import com.catalogApp.catalog.entity.CadruDidactic;
import com.catalogApp.catalog.repository.CadruDidacticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CadruDidacticService {

    @Autowired
    CadruDidacticRepository cadruDidacticRepository;
    public void saveCadruDidactic(CadruDidactic cadruDidactic) {

        cadruDidacticRepository.save(cadruDidactic);

    }

    public List<CadruDidactic> cadreDidactice() {

        return cadruDidacticRepository.findAll();

    }
}
