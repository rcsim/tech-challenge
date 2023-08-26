package br.com.postech30.challenge.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_dependent")
@EqualsAndHashCode
public class Dependent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dateOfBirth;
    private String gender;
    private String parentage;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    private Long userId;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "tb_dependent_appliance",
            joinColumns = @JoinColumn(name = "dependent_id"),
            inverseJoinColumns = @JoinColumn(name = "appliance_id"))
    private Set<Appliance> applianceSet = new HashSet<>();


}