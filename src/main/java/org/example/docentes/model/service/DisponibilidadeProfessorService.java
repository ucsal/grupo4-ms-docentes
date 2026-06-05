package org.example.docentes.model.service;

import lombok.RequiredArgsConstructor;
import org.example.docentes.client.AcademicoClient;
import org.example.docentes.dto.DisponibilidadeDTO;
import org.example.docentes.model.entity.DisponibilidadeProfessor;
import org.example.docentes.model.entity.Professor;
import org.example.docentes.model.repository.DisponibilidadeProfessorRepository;
import org.example.docentes.model.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisponibilidadeProfessorService {

    private final DisponibilidadeProfessorRepository disponibilidadeRepository;
    private final ProfessorRepository professorRepository;
    private final AcademicoClient academicoClient;

    public DisponibilidadeDTO save(DisponibilidadeDTO dto) {
        // Valida se o horário existe no ms-acadêmico antes de salvar
        academicoClient.buscarHorarioPorId(dto.getHorarioId());

        Professor professor = professorRepository.findById(dto.getProfessorId())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        return toDTO(disponibilidadeRepository.save(toEntity(dto, professor)));
    }

    public void delete(Long id) {
        disponibilidadeRepository.deleteById(id);
    }

    public List<DisponibilidadeDTO> findAll() {
        return disponibilidadeRepository.findAll()
                .stream().map(this::toDTO).toList();
    }

    public List<DisponibilidadeDTO> findByProfessor(Long professorId) {
        return disponibilidadeRepository.findByProfessorId(professorId)
                .stream().map(this::toDTO).toList();
    }

    //mapper

    private DisponibilidadeProfessor toEntity(DisponibilidadeDTO dto, Professor professor) {
        DisponibilidadeProfessor d = new DisponibilidadeProfessor();
        d.setProfessor(professor);
        d.setHorarioId(dto.getHorarioId());
        return d;
    }

    private DisponibilidadeDTO toDTO(DisponibilidadeProfessor d) {
        DisponibilidadeDTO dto = new DisponibilidadeDTO();
        dto.setId(d.getId());
        dto.setProfessorId(d.getProfessor().getId());
        dto.setHorarioId(d.getHorarioId());
        return dto;
    }
}