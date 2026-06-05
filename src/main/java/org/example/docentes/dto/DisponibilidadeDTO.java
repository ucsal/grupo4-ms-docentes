package org.example.docentes.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisponibilidadeDTO {
    private Long id;

    @NotNull(message = "Professor é obrigatório")
    private Long professorId;

    @NotNull(message = "Horário é obrigatório")
    private Long horarioId;
}
