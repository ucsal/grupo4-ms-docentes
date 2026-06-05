package org.example.docentes.model.service;

import lombok.RequiredArgsConstructor;
import org.example.docentes.dto.FormacaoDTO;
import org.example.docentes.model.entity.Formacao;
import org.example.docentes.model.entity.Professor;
import org.example.docentes.model.repository.FormacaoRepository;
import org.example.docentes.model.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormacaoService {

    private final FormacaoRepository formacaoRepository;
    private final ProfessorRepository professorRepository;

    public FormacaoDTO save(FormacaoDTO dto) {
        Professor professor = professorRepository.findById(dto.getProfessorId())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        return toDTO(formacaoRepository.save(toEntity(dto, professor)));
    }

    public FormacaoDTO update(Long id, FormacaoDTO dto) {
        Formacao existente = formacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formação não encontrada"));
        existente.setCategoria(dto.getCategoria());
        existente.setNomeInstituicao(dto.getNomeInstituicao());
        existente.setNomeCurso(dto.getNomeCurso());
        existente.setAno(dto.getAno());
        return toDTO(formacaoRepository.save(existente));
    }

    public void delete(Long id) {
        formacaoRepository.deleteById(id);
    }

    public List<FormacaoDTO> findAll() {
        return formacaoRepository.findAll()
                .stream().map(this::toDTO).toList();
    }

    public List<FormacaoDTO> findByProfessor(Long professorId) {
        return formacaoRepository.findByProfessorId(professorId)
                .stream().map(this::toDTO).toList();
    }

    public FormacaoDTO findById(Long id) {
        return toDTO(formacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formação não encontrada")));
    }

    // mapper

    private Formacao toEntity(FormacaoDTO dto, Professor professor) {
        Formacao f = new Formacao();
        f.setCategoria(dto.getCategoria());
        f.setNomeInstituicao(dto.getNomeInstituicao());
        f.setNomeCurso(dto.getNomeCurso());
        f.setAno(dto.getAno());
        f.setProfessor(professor);
        return f;
    }

    private FormacaoDTO toDTO(Formacao f) {
        FormacaoDTO dto = new FormacaoDTO();
        dto.setId(f.getId());
        dto.setCategoria(f.getCategoria());
        dto.setNomeInstituicao(f.getNomeInstituicao());
        dto.setNomeCurso(f.getNomeCurso());
        dto.setAno(f.getAno());
        dto.setProfessorId(f.getProfessor().getId());
        return dto;
    }
}