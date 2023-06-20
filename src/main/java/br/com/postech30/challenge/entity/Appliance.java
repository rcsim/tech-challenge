package br.com.postech30.challenge.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_appliance")
@EqualsAndHashCode
public class Appliance {
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
