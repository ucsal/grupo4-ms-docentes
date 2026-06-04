package org.example.docentes.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.docentes.entity.Horario;
import org.example.docentes.service.HorarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
@CrossOrigin("*")
@RequiredArgsConstructor
public class HorarioController {

    private final HorarioService horarioService;

    @PostMapping
    public ResponseEntity<Horario> save(@Valid @RequestBody Horario horario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(horarioService.save(horario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horario> update(@PathVariable Long id, @Valid @RequestBody Horario horario) {
        return ResponseEntity.ok(horarioService.update(id, horario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        horarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Horario>> findAll() {
        return ResponseEntity.ok(horarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> findById(@PathVariable Long id) {
        return ResponseEntity.ok(horarioService.findById(id));
    }
}
