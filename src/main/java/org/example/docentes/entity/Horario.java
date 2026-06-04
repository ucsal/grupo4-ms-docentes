package org.example.docentes.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.docentes.enums.Dia;
import org.example.docentes.enums.Turno;

import java.time.LocalTime;

@Entity
@Table(name = "horario")
@Getter
@Setter
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "Dia é obrigatório")
    private Dia dia;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "Turno é obrigatório")
    private Turno turno;

    @Column(nullable = false)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaInicio;

    @Column(nullable = false)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaFim;
}
