package com.juliogitdev.sistema_escolar.service;

import com.juliogitdev.sistema_escolar.model.Turma;
import com.juliogitdev.sistema_escolar.repository.TurmaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {
    
    @Autowired
    private TurmaRepository turmarepository;
    
    public List<Turma> listarTodas(){
        return turmarepository.findAll();
    }
    
    public Optional<Turma> buscarPorId(Long id){
        return turmarepository.findById(id);
    }
    
    public Turma salvar(Turma turma){
        return turmarepository.save(turma);
    }
    
    public Turma atualizar(Long id, Turma novaTurma){
        Optional<Turma> turmaExistente = turmarepository.findById(id);
        
        if(turmaExistente.isPresent()){
            Turma turma = turmaExistente.get();
            turma.setNome(novaTurma.getNome());
            turma.setTurno(novaTurma.getTurno());
            turma.setAnoLetivo(novaTurma.getAnoLetivo());
            return turmarepository.save(turma);
        }
        return null;   
    }
    
    public boolean deletar(Long id){
        if(turmarepository.existsById(id)){
            turmarepository.deleteById(id);
            return true;
        }
        
        return false;
    }
    
    public List<Turma> buscarPorNome(String nome){
        return turmarepository.findByNome(nome);
    }
    
    public List<Turma> buscarPorTurno(String turno){
        return turmarepository.findByTurno(turno);
    }
    
    public List<Turma> buscarPorAnoLetivo(int ano){
        return turmarepository.findByAnoLetivo(ano);
    }
    
}
