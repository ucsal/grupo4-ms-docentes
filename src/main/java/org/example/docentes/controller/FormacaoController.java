package org.example.docentes.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.docentes.dto.FormacaoDTO;

import org.example.docentes.model.service.FormacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formacoes")
@CrossOrigin("*")
@RequiredArgsConstructor
public class FormacaoController {

    private final FormacaoService formacaoService;

    @PostMapping
    public ResponseEntity<FormacaoDTO> save(@Valid @RequestBody FormacaoDTO formacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(formacaoService.save(formacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormacaoDTO> update(@PathVariable Long id, @Valid @RequestBody FormacaoDTO formacao) {
        return ResponseEntity.ok(formacaoService.update(id, formacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        formacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<FormacaoDTO>> findAll() {
        return ResponseEntity.ok(formacaoService.findAll());
    }

    @GetMapping("/professor/{professorId}")
    public ResponseEntity<List<FormacaoDTO>> findByProfessor(@PathVariable Long professorId) {
        return ResponseEntity.ok(formacaoService.findByProfessor(professorId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormacaoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(formacaoService.findById(id));
    }
}