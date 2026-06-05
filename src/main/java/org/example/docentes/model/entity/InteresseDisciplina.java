package org.example.docentes.model.entity;

//import com.seugrupo.docentes.enums.Prioridade;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.docentes.enums.Prioridade;

@Entity
@Table(name = "interesse_disciplina")
@Getter
@Setter
public class InteresseDisciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private Prioridade prioridade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    // Referência ao domínio externo de Disciplinas — apenas o ID
    @Column(nullable = false)
    private Long disciplinaId;
}
