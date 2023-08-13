package br.com.postech30.challenge.entity;

import lombok.*;

import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_appliance")
@EqualsAndHashCode
public class Appliance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String model;
    @Getter
    @Setter
    private String power;
    @Getter
    @Setter
    private String manufacturer;

    @Getter
    @Setter
    @ManyToOne
    private Address address;

}
