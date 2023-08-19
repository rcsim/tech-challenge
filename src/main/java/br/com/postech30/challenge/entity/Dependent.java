package br.com.postech30.challenge.entity;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_dependent")
@EqualsAndHashCode
public class Dependent {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private LocalDate dateOfBirth;

    @Getter
    @Setter
    private String gender;

    @Getter
    @Setter
    private String parentage;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Getter
    @Setter
    private Long userId;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "tb_dependent_appliance",
            joinColumns = @JoinColumn(name = "dependent_id"),
            inverseJoinColumns = @JoinColumn(name = "appliance_id"))
    private Set<Appliance> applianceSet = new HashSet<>();


}