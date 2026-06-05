package org.example.docentes.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.docentes.enums.Categoria;

@Getter
@Setter
public class FormacaoDTO {
    private Long id;

    @NotNull(message = "Categoria é obrigatória")
    private Categoria categoria;

    private String nomeInstituicao;
    private String nomeCurso;
    private Integer ano;

    @NotNull(message = "Professor é obrigatório")
    private Long professorId;
}
