package org.example.docentes.model.repository;

import org.example.docentes.model.entity.DisponibilidadeProfessor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisponibilidadeProfessorRepository extends JpaRepository<DisponibilidadeProfessor, Long> {
    List<DisponibilidadeProfessor> findByProfessorId(Long professorId);
}
