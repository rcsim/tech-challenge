package br.com.postech30.challenge.entity;

import lombok.*;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_appliance")
@EqualsAndHashCode
public class Appliance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String model;
    private String power;
    private String manufacturer;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private Long userId;

    @ManyToMany(mappedBy = "applianceSet", cascade = CascadeType.ALL)
    private Set<Dependent> dependentSet =  new HashSet<>();

}
