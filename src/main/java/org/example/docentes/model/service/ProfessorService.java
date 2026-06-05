package org.example.docentes.model.service;

import lombok.RequiredArgsConstructor;
import org.example.docentes.dto.ProfessorDTO;
import org.example.docentes.model.entity.Professor;
import org.example.docentes.model.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorDTO save(ProfessorDTO dto) {
        Professor professor = toEntity(dto);
        return toDTO(professorRepository.save(professor));
    }

    public ProfessorDTO update(Long id, ProfessorDTO dto) {
        Professor existente = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        existente.setNome(dto.getNome());
        existente.setEmail(dto.getEmail());
        existente.setTelefone(dto.getTelefone());
        existente.setMatricula(dto.getMatricula());
        existente.setEscolaId(dto.getEscolaId());
        return toDTO(professorRepository.save(existente));
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

    public List<ProfessorDTO> findAll() {
        return professorRepository.findByStatusAtivo(true)
                .stream().map(this::toDTO).toList();
    }

    public List<ProfessorDTO> findAllInativos() {
        return professorRepository.findByStatusAtivo(false)
                .stream().map(this::toDTO).toList();
    }

    public ProfessorDTO findById(Long id) {
        return toDTO(professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado")));
    }

    public ProfessorDTO findByUsername(String username) {
        return professorRepository.findByEmail(username)
                .map(this::toDTO)
                .orElse(null); // retorna null se não for professor
    }

    // mapper

    private Professor toEntity(ProfessorDTO dto) {
        Professor p = new Professor();
        p.setNome(dto.getNome());
        p.setMatricula(dto.getMatricula());
        p.setEmail(dto.getEmail());
        p.setTelefone(dto.getTelefone());
        p.setEscolaId(dto.getEscolaId());
        return p;
    }

    private ProfessorDTO toDTO(Professor p) {
        ProfessorDTO dto = new ProfessorDTO();
        dto.setId(p.getId());
        dto.setNome(p.getNome());
        dto.setMatricula(p.getMatricula());
        dto.setEmail(p.getEmail());
        dto.setTelefone(p.getTelefone());
        dto.setEscolaId(p.getEscolaId());
        dto.setStatusAtivo(p.isStatusAtivo());
        return dto;
    }
}