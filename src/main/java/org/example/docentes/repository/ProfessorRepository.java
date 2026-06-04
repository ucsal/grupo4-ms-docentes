package org.example.docentes.repository;

import org.example.docentes.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    List<Professor> findByStatusAtivo(boolean statusAtivo);
}
