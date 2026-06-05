package org.example.docentes.controller;

import lombok.RequiredArgsConstructor;
import org.example.docentes.model.entity.InteresseDisciplina;
import org.example.docentes.model.service.InteresseDisciplinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interesses-disciplina")
@CrossOrigin("*")
@RequiredArgsConstructor
public class InteresseDisciplinaController {

    private final InteresseDisciplinaService interesseService;

    @PostMapping
    public ResponseEntity<InteresseDisciplina> save(@RequestBody InteresseDisciplina interesse) {
        return ResponseEntity.status(HttpStatus.CREATED).body(interesseService.save(interesse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        interesseService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<InteresseDisciplina>> findAll() {
        return ResponseEntity.ok(interesseService.findAll());
    }

    @GetMapping("/professor/{professorId}")
    public ResponseEntity<List<InteresseDisciplina>> findByProfessor(@PathVariable Long professorId) {
        return ResponseEntity.ok(interesseService.findByProfessor(professorId));
    }
}