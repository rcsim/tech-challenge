package br.com.postech30.challenge.dto;

import br.com.postech30.challenge.entity.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    @Getter
    private Long id;
    @JsonProperty
    @Getter
    @NotBlank(message = "A rua é um campo de preenchimento obrigatório")
    private String street;
    @JsonProperty
    @Getter
    @NotBlank(message = "O número é um campo de preenchimento obrigatório")
    private String number;
    @JsonProperty
    @Getter
    @NotBlank(message = "O bairro é um campo de preenchimento obrigatório")
    private String district;
    @JsonProperty
    @Getter
    @NotBlank(message = "A cidade é um campo de preenchimento obrigatório")
    private String city;
    @JsonProperty
    @Getter
    @NotBlank(message = "O estado é um campo de preenchimento obrigatório")
    private String state;

    public AddressDTO(Address entity) {
        this.id = entity.getId();
        this.street = entity.getStreet();
        this.number = entity.getNumber();
        this.district = entity.getDistrict();
        this.city = entity.getCity();
        this.state = entity.getState();
    }

}
