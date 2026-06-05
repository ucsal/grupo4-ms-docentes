package org.example.docentes.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.docentes.enums.Prioridade;

@Getter
@Setter
public class InteresseDTO {
    private Long id;

    @NotNull(message = "Professor é obrigatório")
    private Long professorId;

    @NotNull(message = "Disciplina é obrigatória")
    private Long disciplinaId;

    private Prioridade prioridade;
}
