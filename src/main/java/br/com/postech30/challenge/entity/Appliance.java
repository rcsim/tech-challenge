package br.com.postech30.challenge.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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
    @JoinColumn(name = "address_id")
    private Address address;

    @Getter
    @Setter
    private Long userId;

    @ManyToMany(mappedBy = "applianceSet", cascade = CascadeType.ALL)
    private Set<Dependent> dependentSet =  new HashSet<>();


}
