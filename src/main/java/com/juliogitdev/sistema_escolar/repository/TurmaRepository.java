package com.juliogitdev.sistema_escolar.repository;

import com.juliogitdev.sistema_escolar.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    
    //Busca turma pelo nome exato
    List<Turma> findByNome(String nome);
    
    List<Turma> findByTurno(String turno);
    
    List<Turma> findByAnoLetivo(int ano);
}