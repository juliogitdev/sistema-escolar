package com.juliogitdev.sistema_escolar.repository;

import com.juliogitdev.sistema_escolar.model.Aluno;
import com.juliogitdev.sistema_escolar.model.Turma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, String> {
    
    Optional<Aluno> findByNome(String nome);
    
    Optional<Aluno> findByEmail(String email);
    
    Optional<Aluno> findBySituacao(String situacao);
    
}
