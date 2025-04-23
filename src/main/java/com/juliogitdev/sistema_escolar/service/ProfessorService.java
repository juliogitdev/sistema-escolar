package com.juliogitdev.sistema_escolar.service;

import com.juliogitdev.sistema_escolar.model.Professor;
import com.juliogitdev.sistema_escolar.repository.ProfessorRepository;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.List;
import java.util.Optional;


@Service
public class ProfessorService {
    
    @Autowired
    private ProfessorRepository professorrepository;    
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    
    public List<Professor> listarTodos(){
        return professorrepository.findAll();
    }
    
    public Optional<Professor> buscarPorMatricula(String matricula){
        return professorrepository.findById(matricula);
    }
    
    
    public Optional<Professor> buscarPorEmail(String email){
        return professorrepository.findByEmail(email);
    }
    
    public Optional<Professor> buscarPeloNome(String nome){
        return professorrepository.findByNome(nome);
    }
    
    public Professor salvar(Professor professor){
        
        if(professor.getMatricula() == null){
            professor.setDataAdmissao(LocalDate.now());
        }
        
        String senhaCriptografada = passwordEncoder.encode(professor.getSenha());
        professor.setSenha(senhaCriptografada);
        return professorrepository.save(professor);
    }
    
    public Professor atualizar(String matricula, Professor novoProfessor){
        Optional<Professor> professorExistente = professorrepository.findById(matricula);
        
        if(professorExistente.isPresent()){
            Professor professor = professorExistente.get();
            professor.setNome(novoProfessor.getNome());
            professor.setEmail(novoProfessor.getEmail());
            professor.setFormacao(novoProfessor.getFormacao());
            
            return professorrepository.save(professor);
            
        }
        return null;
    }
    
    public boolean deletar(String matricula){
        if(professorrepository.existsById(matricula)){
            professorrepository.deleteById(matricula);
            return true;
        }return false;
    }
    
}
