package br.com.postech30.challenge.dto;

import br.com.postech30.challenge.entity.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Long id;

    @JsonProperty
    @NotBlank(message = "A rua é um campo de preenchimento obrigatório")
    private String street;

    @JsonProperty
    @NotBlank(message = "O número é um campo de preenchimento obrigatório")
    private String number;

    @JsonProperty
    @NotBlank(message = "O bairro é um campo de preenchimento obrigatório")
    private String district;

    @JsonProperty
    @NotBlank(message = "A cidade é um campo de preenchimento obrigatório")
    private String city;

    @JsonProperty
    @NotBlank(message = "O estado é um campo de preenchimento obrigatório")
    private String state;

    @JsonProperty
    @NotNull(message = "O endereço precisa estar associado a um usuário")
    private Long userId;

    public AddressDTO(Address entity) {
        this.id = entity.getId();
        this.street = entity.getStreet();
        this.number = entity.getNumber();
        this.district = entity.getDistrict();
        this.city = entity.getCity();
        this.state = entity.getState();
        this.userId = entity.getUserId();
    }

}
