package org.example.docentes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorDTO {
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private Integer matricula;

    @Email(message = "E-mail inválido")
    private String email;

    private String telefone;
    private Long escolaId;
    private boolean statusAtivo;
}