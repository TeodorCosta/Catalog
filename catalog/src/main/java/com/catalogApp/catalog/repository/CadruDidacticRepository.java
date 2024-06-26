package com.catalogApp.catalog.repository;


import com.catalogApp.catalog.entity.CadruDidactic;
import com.catalogApp.catalog.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CadruDidacticRepository extends JpaRepository <CadruDidactic, UUID> {

    List<CadruDidactic> findByNumeContainingIgnoreCaseOrPrenumeContainingIgnoreCase(String nume, String prenume);

}
