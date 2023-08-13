package br.com.postech30.challenge.dto;

import br.com.postech30.challenge.entity.Appliance;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;


import jakarta.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
public class ApplianceDTO {

    @Getter
    private Long id;
    @JsonProperty
    @Getter
    @NotBlank(message = "name é um campo obrigatório")
    private String name;
    @JsonProperty
    @Getter
    @NotBlank(message = "model é um campo obrigatório")
    private String model;
    @JsonProperty
    @NotBlank(message = "power é um campo obrigatório")
    @NumberFormat
    @Getter
    private String power;
    @JsonProperty
    @Getter
    @NotBlank(message = "manufacturer é um campo obrigatório")
    private String manufacturer;

    public ApplianceDTO(Appliance entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.model = entity.getModel();
        this.power = entity.getPower();
        this.manufacturer = entity.getManufacturer();
       }
}
