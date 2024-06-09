package com.catalogApp.catalog.repository;

import com.catalogApp.catalog.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<Nota,Integer> {

}
