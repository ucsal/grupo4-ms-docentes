package org.example.docentes.model.repository;

import org.example.docentes.model.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    List<Professor> findByStatusAtivo(boolean statusAtivo);

    Optional<Professor> findByEmail(String email);

}
