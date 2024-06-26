package com.catalogApp.catalog.repository;

import com.catalogApp.catalog.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository <Student, UUID>{

    List<Student> findByNumeContainingIgnoreCaseOrPrenumeContainingIgnoreCase(String nume, String prenume);

    List<Student> findByGrupa(String grupa);
}
