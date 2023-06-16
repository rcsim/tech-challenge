package br.com.postech30.challenge.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor(force = true)
public class DependentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome é um campo de preenchimento obrigatório")
    private String name;

    @NotNull(message = "Data de nascimento é um campo de preenchimento obrigatório")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthday;

    @NotNull(message = "Gênero é um campo de preenchimento obrigatório")
    private String gender;

    @NotNull(message = "Parentesco é um campo de preenchimento obrigatório")
    private String parentage;

}