package com.juliogitdev.sistema_escolar.repository;

import com.juliogitdev.sistema_escolar.model.Professor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, String>{
    
    Optional<Professor> findByEmail (String email);
    Optional<Professor> findByNome (String nome);
}
