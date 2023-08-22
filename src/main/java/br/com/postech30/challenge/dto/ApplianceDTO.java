package br.com.postech30.challenge.dto;

import br.com.postech30.challenge.entity.Appliance;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplianceDTO {

    private Long id;

    @JsonProperty
    @NotEmpty(message = "Nome é um campo obrigatório")
    private String name;

    @JsonProperty
    @NotEmpty(message = "Modelo é um campo obrigatório")
    private String model;

    @JsonProperty
    @NotEmpty(message = "Potência é um campo obrigatório")
    @NumberFormat
    private String power;

    @JsonProperty
    @NotEmpty(message = "Fabricante é um campo obrigatório")
    private String manufacturer;

    @JsonProperty
    @NotNull(message = "O eletrodoméstico precisa estar associado a um endereço")
    private Long addressId;

    @JsonProperty
    @NotNull(message = "O eletrodoméstico precisa estar associado a um usuário")
    private Long userId;

    public ApplianceDTO(Appliance entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.model = entity.getModel();
        this.power = entity.getPower();
        this.manufacturer = entity.getManufacturer();
        this.addressId = entity.getAddress().getId();
        this.userId = entity.getUserId();
       }
}
