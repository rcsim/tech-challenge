package br.com.postech30.challenge.dto;

import br.com.postech30.challenge.entity.Dependent;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
public class DependentDTO {
    @Getter
    private Long id;
    @JsonProperty
    @Getter
    @NotEmpty(message = "O nome é obrigatório")
    private String name;
    @JsonProperty
    @Getter
    @NotNull(message = "A data de nascimento é obrigatória. Padrão dd/MM/yyyy")
    @Past(message = "A data de nascimento precisa estar no passado.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
    @JsonProperty
    @Getter
    @NotEmpty(message = "O gênero é obrigatório.")
    private String gender;
    @JsonProperty
    @Getter
    @NotEmpty(message = "O parentesco é obrigatório.")
    private String parentage;

    @Getter
    @NotNull(message = "O endereço precisa estar associado a um endereço")
    private Long addressId;

    @Getter
    @NotNull(message = "O endereço precisa estar associado a um usuário")
    private Long userId;

    public DependentDTO(Dependent dependent) {
        this.id = dependent.getId();
        this.name = dependent.getName();
        this.dateOfBirth = dependent.getDateOfBirth();
        this.gender = dependent.getGender();
        this.parentage = dependent.getParentage();
        this.addressId = dependent.getAddress().getId();
        this.userId = dependent.getUserId();
    }

}