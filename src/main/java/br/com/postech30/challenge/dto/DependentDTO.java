package br.com.postech30.challenge.dto;

import br.com.postech30.challenge.entity.Dependent;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DependentDTO {

    private Long id;

    @JsonProperty
    @NotEmpty(message = "O nome é obrigatório")
    private String name;

    @JsonProperty
    @NotNull(message = "A data de nascimento é obrigatória. Padrão dd/MM/yyyy")
    @Past(message = "A data de nascimento precisa estar no passado.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;

    @JsonProperty
    @NotEmpty(message = "O gênero é obrigatório.")
    private String gender;

    @JsonProperty
    @NotEmpty(message = "O parentesco é obrigatório.")
    private String parentage;

    @NotNull(message = "O dependente precisa estar associado a um endereço")
    private Long addressId;

    @NotNull(message = "O dependente precisa estar associado a um usuário")
    private Long userId;


    public DependentDTO(Dependent dependent) {
        this.id = dependent.getId();
        this.name = dependent.getName();
        this.dateOfBirth = LocalDate.parse(dependent.getDateOfBirth());
        this.gender = dependent.getGender();
        this.parentage = dependent.getParentage();
        this.addressId = dependent.getAddress().getId();
        this.userId = dependent.getUserId();
    }

}