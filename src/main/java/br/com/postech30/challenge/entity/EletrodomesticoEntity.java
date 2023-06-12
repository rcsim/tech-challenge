package br.com.postech30.challenge.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor(force = true)
public class EletrodomesticoEntity {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String nome;
    @NotNull
    private String modelo;
    @NotNull
    @NumberFormat
    private String potencia;
    @NotNull
    private String fabricante;



}
