package org.example.docentes.model.service;

import lombok.RequiredArgsConstructor;
import org.example.docentes.dto.InteresseDTO;
import org.example.docentes.model.entity.InteresseDisciplina;
import org.example.docentes.model.entity.Professor;
import org.example.docentes.model.repository.InteresseDisciplinaRepository;
import org.example.docentes.model.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InteresseDisciplinaService {

    private final InteresseDisciplinaRepository interesseRepository;
    private final ProfessorRepository professorRepository;

    public InteresseDTO save(InteresseDTO dto) {
        Professor professor = professorRepository.findById(dto.getProfessorId())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        return toDTO(interesseRepository.save(toEntity(dto, professor)));
    }

    public void delete(Long id) {
        interesseRepository.deleteById(id);
    }

    public List<InteresseDTO> findByProfessor(Long professorId) {
        return interesseRepository.findByProfessorIdOrderByPrioridade(professorId)
                .stream().map(this::toDTO).toList();
    }

    public List<InteresseDTO> findAll() {
        return interesseRepository.findAllByOrderByPrioridade()
                .stream().map(this::toDTO).toList();
    }

    // mapper

    private InteresseDisciplina toEntity(InteresseDTO dto, Professor professor) {
        InteresseDisciplina i = new InteresseDisciplina();
        i.setProfessor(professor);
        i.setDisciplinaId(dto.getDisciplinaId());
        i.setPrioridade(dto.getPrioridade());
        return i;
    }

    private InteresseDTO toDTO(InteresseDisciplina i) {
        InteresseDTO dto = new InteresseDTO();
        dto.setId(i.getId());
        dto.setProfessorId(i.getProfessor().getId());
        dto.setDisciplinaId(i.getDisciplinaId());
        dto.setPrioridade(i.getPrioridade());
        return dto;
    }
}