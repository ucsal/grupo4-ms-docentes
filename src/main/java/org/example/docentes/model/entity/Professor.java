package org.example.docentes.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "professor")
@Getter
@Setter
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Column(unique = true)
    private Integer matricula;

    @Email(message = "E-mail inválido")
    @Column(unique = true)
    private String email;

    private String telefone;

    //escola é referenciada apenas pelo ID
    private Long escolaId;

    private boolean statusAtivo = true;
}