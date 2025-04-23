package com.juliogitdev.sistema_escolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.juliogitdev.sistema_escolar.model.Aluno;
import com.juliogitdev.sistema_escolar.service.AlunoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;
    
    @GetMapping
    public List<Aluno> listarAlunos(){
        return alunoService.listarTodos();
    }
    
    @GetMapping("/{matricula}")
    public ResponseEntity<Aluno> buscarPorMatricula(@PathVariable String matricula){
        Optional<Aluno> aluno = alunoService.buscarPorMatricula(matricula);
        return aluno.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @PostMapping
    public ResponseEntity<Aluno> cadastrar(@RequestBody Aluno aluno){
        Aluno salvo = alunoService.salvar(aluno);
        return new ResponseEntity<>(salvo, HttpStatus.CREATED);
    }
    
    // PUT /aluno/{matricula}
    @PutMapping("/{matricula}")
    public ResponseEntity<Aluno> atualizar(@PathVariable String matricula, @RequestBody Aluno alunoAtualizado){
        Aluno atualizado = alunoService.atualizar(matricula, alunoAtualizado);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> deletar(@PathVariable String matricula){
        boolean deletado = alunoService.deletar(matricula);
        if (deletado) {
            return ResponseEntity.noContent().build(); // 204
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
}
