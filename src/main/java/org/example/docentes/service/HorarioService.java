package org.example.docentes.service;

import lombok.RequiredArgsConstructor;
import org.example.docentes.entity.Horario;
import org.example.docentes.repository.HorarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HorarioService {

    private final HorarioRepository horarioRepository;

    public Horario save(Horario horario) {
        return horarioRepository.save(horario);
    }

    public Horario update(Long id, Horario dados) {
        Horario existente = horarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horário não encontrado"));
        existente.setDia(dados.getDia());
        existente.setTurno(dados.getTurno());
        existente.setHoraInicio(dados.getHoraInicio());
        existente.setHoraFim(dados.getHoraFim());
        return horarioRepository.save(existente);
    }

    public void delete(Long id) {
        horarioRepository.deleteById(id);
    }

    public List<Horario> findAll() {
        return horarioRepository.findAll();
    }

    public Horario findById(Long id) {
        return horarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horário não encontrado"));
    }
}
