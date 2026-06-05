package org.example.docentes.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.docentes.dto.ProfessorDTO;
import org.example.docentes.model.entity.Professor;
import org.example.docentes.model.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professores")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorDTO> save(@Valid @RequestBody ProfessorDTO professor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.save(professor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorDTO> update(@PathVariable Long id, @Valid @RequestBody ProfessorDTO professor) {
        return ResponseEntity.ok(professorService.update(id, professor));
    }

    @PatchMapping("/{id}/inativar")
    public ResponseEntity<Void> inativar(@PathVariable Long id) {
        professorService.inativar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/reativar")
    public ResponseEntity<Void> reativar(@PathVariable Long id) {
        professorService.reativar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProfessorDTO>> findAll() {
        return ResponseEntity.ok(professorService.findAll());
    }

    @GetMapping("/inativos")
    public ResponseEntity<List<ProfessorDTO>> findAllInativos() {
        return ResponseEntity.ok(professorService.findAllInativos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(professorService.findById(id));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<ProfessorDTO> findByUsername(@PathVariable String username) {
        return ResponseEntity.ok(professorService.findByUsername(username));
    }

}