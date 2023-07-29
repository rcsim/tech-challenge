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
    private int id;
    @JsonProperty
    @NotBlank(message = "name é um campo obrigatório")
    private String name;
    @JsonProperty
    @NotBlank(message = "model é um campo obrigatório")
    private String model;
    @JsonProperty
    @NotBlank(message = "power é um campo obrigatório")
    @NumberFormat
    private String power;
    @JsonProperty
    @NotBlank(message = "manufacturer é um campo obrigatório")
    private String manufacturer;

    public ApplianceDTO(Appliance entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.model = entity.getModel();
        this.power = entity.getPower();
        this.manufacturer = entity.getManufacturer();
       }

    public Appliance mapToAppliance() {
        return new Appliance(id, name, model, power, manufacturer);
    }
}
