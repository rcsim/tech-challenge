package br.com.postech30.challenge.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_eletrodomestico")
@EqualsAndHashCode
public class EletrodomesticoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String modelo;
    @Getter
    @Setter
    private String potencia;
    @Getter
    @Setter
    private String fabricante;



}
