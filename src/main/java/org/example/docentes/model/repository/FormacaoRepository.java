package org.example.docentes.model.repository;

import org.example.docentes.model.entity.Formacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormacaoRepository extends JpaRepository<Formacao, Long> {
    List<Formacao> findByProfessorId(Long professorId);
}
