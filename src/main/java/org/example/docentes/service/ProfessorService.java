package org.example.docentes.service;

import lombok.RequiredArgsConstructor;
import org.example.docentes.entity.Professor;
import org.example.docentes.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor update(Long id, Professor dados) {
        Professor existente = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        existente.setNome(dados.getNome());
        existente.setEmail(dados.getEmail());
        existente.setTelefone(dados.getTelefone());
        existente.setEscolaId(dados.getEscolaId());
        return professorRepository.save(existente);
    }

    public void inativar(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        professor.setStatusAtivo(false);
        professorRepository.save(professor);
    }

    public void reativar(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        professor.setStatusAtivo(true);
        professorRepository.save(professor);
    }

    public List<Professor> findAll() {
        return professorRepository.findByStatusAtivo(true);
    }

    public List<Professor> findAllInativos() {
        return professorRepository.findByStatusAtivo(false);
    }

    public Professor findById(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
    }
}
