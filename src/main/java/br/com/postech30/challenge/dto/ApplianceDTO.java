package br.com.postech30.challenge.dto;

import br.com.postech30.challenge.entity.Appliance;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;


import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
public class ApplianceDTO {

    @Getter
    private int id;
    @JsonProperty
    @NotBlank(message = "Esse é um campo de preenchimento obrigatório")
    private String name;
    @JsonProperty
    @NotBlank(message = "Esse é um campo de preenchimento obrigatório")
    private String model;
    @JsonProperty
    @NotBlank(message = "Esse é um campo de preenchimento obrigatório")
    @NumberFormat
    private String power;
    @JsonProperty
    @NotBlank(message = "Esse é um campo de preenchimento obrigatório")
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
