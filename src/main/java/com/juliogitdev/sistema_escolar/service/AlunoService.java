package com.juliogitdev.sistema_escolar.service;

import com.juliogitdev.sistema_escolar.repository.AlunoRepository;
import com.juliogitdev.sistema_escolar.model.Aluno;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    
    @Autowired
    private AlunoRepository alunorepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    public List<Aluno> listarTodos(){
        return alunorepository.findAll();
    }
    
    public Optional<Aluno> buscarPorMatricula(String matricula){
        return alunorepository.findById(matricula);
    }
    
    public Optional<Aluno> buscarPeloNome(String nome){
        return alunorepository.findByNome(nome);
    }
    
    public Optional<Aluno> buscarPeloEmail(String email){
        return alunorepository.findByEmail(email);
    }
    
    public Optional<Aluno> buscarPelaSituacao(String situacao){
        return alunorepository.findBySituacao(situacao);
    }
    
    public Aluno salvar(Aluno aluno){
        String senhaCriptografada = passwordEncoder.encode(aluno.getSenha());
        aluno.setSenha(senhaCriptografada);
        
        return alunorepository.save(aluno);
    }
    
    public Aluno atualizar(String matricula, Aluno alunoNovo){
        Optional<Aluno> alunoExistente = alunorepository.findById(matricula);
        
        if(alunoExistente.isPresent()){
            Aluno aluno = alunoExistente.get();
            aluno.setDataNascimento(alunoNovo.getDataNascimento());
            aluno.setNome(alunoNovo.getNome());
            aluno.setEmail(alunoNovo.getEmail());
            aluno.setSituacao(alunoNovo.getSituacao());
            aluno.setTurma(alunoNovo.getTurma());
            
            return alunorepository.save(aluno);
        }return null;
    }
    
    public boolean deletar(String matricula){
        if(alunorepository.existsById(matricula)){
            alunorepository.deleteById(matricula);
            return true;
        }return false;
    }
    
}
