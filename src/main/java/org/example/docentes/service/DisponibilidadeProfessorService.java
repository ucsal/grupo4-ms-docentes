package org.example.docentes.service;

import lombok.RequiredArgsConstructor;
import org.example.docentes.entity.DisponibilidadeProfessor;
import org.example.docentes.repository.DisponibilidadeProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisponibilidadeProfessorService {

    private final DisponibilidadeProfessorRepository disponibilidadeRepository;

    public DisponibilidadeProfessor save(DisponibilidadeProfessor disponibilidade) {
        return disponibilidadeRepository.save(disponibilidade);
    }

    public void delete(Long id) {
        disponibilidadeRepository.deleteById(id);
    }

    public List<DisponibilidadeProfessor> findAll() {
        return disponibilidadeRepository.findAll();
    }

    public List<DisponibilidadeProfessor> findByProfessor(Long professorId) {
        return disponibilidadeRepository.findByProfessorId(professorId);
    }
}