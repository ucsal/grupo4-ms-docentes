package org.example.docentes.service;

import lombok.RequiredArgsConstructor;
import org.example.docentes.entity.Formacao;
import org.example.docentes.repository.FormacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormacaoService {

    private final FormacaoRepository formacaoRepository;

    public Formacao save(Formacao formacao) {
        return formacaoRepository.save(formacao);
    }

    public Formacao update(Long id, Formacao dados) {
        Formacao existente = formacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formação não encontrada"));
        existente.setCategoria(dados.getCategoria());
        existente.setNomeInstituicao(dados.getNomeInstituicao());
        existente.setNomeCurso(dados.getNomeCurso());
        existente.setAno(dados.getAno());
        return formacaoRepository.save(existente);
    }

    public void delete(Long id) {
        formacaoRepository.deleteById(id);
    }

    public List<Formacao> findAll() {
        return formacaoRepository.findAll();
    }

    public List<Formacao> findByProfessor(Long professorId) {
        return formacaoRepository.findByProfessorId(professorId);
    }

    public Formacao findById(Long id) {
        return formacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formação não encontrada"));
    }
}
