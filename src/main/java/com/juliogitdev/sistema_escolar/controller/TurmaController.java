    package com.juliogitdev.sistema_escolar.controller;

    import com.juliogitdev.sistema_escolar.model.Turma;
    import com.juliogitdev.sistema_escolar.service.TurmaService;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/turma")
    public class TurmaController {

        @Autowired
        private TurmaService turmaService;

        // Método para listar todas as turmas
        @GetMapping
        public List<Turma> listarTurmas() {
            return turmaService.listarTodas();
        }

        // Método para buscar turma por ID
        @GetMapping("/{id}")
        public ResponseEntity<Turma> buscarTurmaPorId(@PathVariable Long id) {
            Optional <Turma> turma = turmaService.buscarPorId(id);
            return turma.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        }

        // Método para buscar turmas por nome
        @GetMapping("/nome/{nome}")
        public List<Turma> buscarTurmasPorNome(@PathVariable String nome) {
            return turmaService.buscarPorNome(nome);
        }

        // Método para buscar turmas por turno
        @GetMapping("/turno/{turno}")
        public List<Turma> buscarTurmasPorTurno(@PathVariable String turno) {
            return turmaService.buscarPorTurno(turno);
        }

        // Método para buscar turmas por ano letivo
        @GetMapping("/ano/{ano}")
        public List<Turma> buscarTurmasPorAnoLetivo(@PathVariable int ano) {
            return turmaService.buscarPorAnoLetivo(ano);
        }

        // Método para criar uma nova turma
        @PostMapping
        public ResponseEntity<Turma> criarTurma(@RequestBody Turma turma) {
            Turma novaTurma = turmaService.salvar(turma);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaTurma);
        }

        // Método para atualizar uma turma existente
        @PutMapping("/{id}")
        public ResponseEntity<Turma> atualizarTurma(@PathVariable Long id, @RequestBody Turma turma) {
            Optional<Turma> turmaExistente = turmaService.buscarPorId(id);
            if (!turmaExistente.isPresent()) {
                turma.setId(id); // Garantir que o ID da turma seja mantido
                Turma turmaAtualizada = turmaService.salvar(turma);
                return ResponseEntity.ok(turmaAtualizada);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }

        // Método para deletar uma turma
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarTurma(@PathVariable Long id) {
            if (!turmaService.buscarPorId(id).isEmpty()) {
                turmaService.deletar(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }
    }