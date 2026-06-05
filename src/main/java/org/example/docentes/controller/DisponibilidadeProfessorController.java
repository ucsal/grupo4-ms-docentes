package org.example.docentes.controller;

import lombok.RequiredArgsConstructor;
import org.example.docentes.dto.DisponibilidadeDTO;
import org.example.docentes.model.service.DisponibilidadeProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disponibilidades")
@CrossOrigin("*")
@RequiredArgsConstructor
public class DisponibilidadeProfessorController {

    private final DisponibilidadeProfessorService disponibilidadeService;

    @PostMapping
    public ResponseEntity<DisponibilidadeDTO> save(@RequestBody DisponibilidadeDTO disponibilidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(disponibilidadeService.save(disponibilidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        disponibilidadeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<DisponibilidadeDTO>> findAll() {
        return ResponseEntity.ok(disponibilidadeService.findAll());
    }

    @GetMapping("/professor/{professorId}")
    public ResponseEntity<List<DisponibilidadeDTO>> findByProfessor(@PathVariable Long professorId) {
        return ResponseEntity.ok(disponibilidadeService.findByProfessor(professorId));
    }
}
