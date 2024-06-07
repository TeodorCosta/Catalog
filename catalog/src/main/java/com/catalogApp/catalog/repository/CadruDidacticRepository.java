package com.catalogApp.catalog.repository;


import com.catalogApp.catalog.entity.CadruDidactic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CadruDidacticRepository extends JpaRepository <CadruDidactic, UUID> {

}
