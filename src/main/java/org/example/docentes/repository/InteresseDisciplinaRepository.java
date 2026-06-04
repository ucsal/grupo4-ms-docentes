package org.example.docentes.repository;

import org.example.docentes.entity.InteresseDisciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InteresseDisciplinaRepository extends JpaRepository<InteresseDisciplina, Long> {
    List<InteresseDisciplina> findByProfessorIdOrderByPrioridade(Long professorId);
    List<InteresseDisciplina> findAllByOrderByPrioridade();
}
