package org.example.docentes.service;

import lombok.RequiredArgsConstructor;
import org.example.docentes.entity.InteresseDisciplina;
import org.example.docentes.repository.InteresseDisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InteresseDisciplinaService {

    private final InteresseDisciplinaRepository interesseRepository;

    public InteresseDisciplina save(InteresseDisciplina interesse) {
        return interesseRepository.save(interesse);
    }

    public void delete(Long id) {
        interesseRepository.deleteById(id);
    }

    public List<InteresseDisciplina> findByProfessor(Long professorId) {
        return interesseRepository.findByProfessorIdOrderByPrioridade(professorId);
    }

    public List<InteresseDisciplina> findAll() {
        return interesseRepository.findAllByOrderByPrioridade();
    }
}