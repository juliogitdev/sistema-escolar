package com.juliogitdev.sistema_escolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.juliogitdev.sistema_escolar.model.Professor;
import com.juliogitdev.sistema_escolar.service.ProfessorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    
    @Autowired
    private ProfessorService professorService;

    // GET /professor
    @GetMapping
    public List<Professor> listarProfessores(){
        return professorService.listarTodos();
    }

    // GET /professor/matricula/{matricula}
    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<Professor> buscarPorMatricula(@PathVariable String matricula){
        Optional<Professor> professor = professorService.buscarPorMatricula(matricula);
        return professor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // POST /professor
    @PostMapping
    public ResponseEntity<Professor> cadastrar(@RequestBody Professor professor){
        Professor salvo = professorService.salvar(professor);
        return new ResponseEntity<>(salvo, HttpStatus.CREATED);
    }

    // PUT /professor/{matricula}
    @PutMapping("/{matricula}")
    public ResponseEntity<Professor> atualizar(@PathVariable String matricula, @RequestBody Professor professorAtualizado){
        Professor atualizado = professorService.atualizar(matricula, professorAtualizado);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // DELETE /professor/{matricula}
    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> deletar(@PathVariable String matricula){
        boolean deletado = professorService.deletar(matricula);
        if (deletado) {
            return ResponseEntity.noContent().build(); // 204
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
