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
    private String nome;
    @JsonProperty
    @NotBlank(message = "Esse é um campo de preenchimento obrigatório")
    private String modelo;
    @JsonProperty
    @NotBlank(message = "Esse é um campo de preenchimento obrigatório")
    @NumberFormat
    private String potencia;
    @JsonProperty
    @NotBlank(message = "Esse é um campo de preenchimento obrigatório")
    private String fabricante;

    public ApplianceDTO(Appliance entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.modelo = entity.getModelo();
        this.potencia = entity.getPotencia();
        this.fabricante = entity.getFabricante();
       }

    public Appliance mapToAppliance() {
        return new Appliance(id, nome, modelo, potencia, fabricante);
    }
}
