package br.com.postech30.challenge.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_address")
@EqualsAndHashCode
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    @Setter
    @Column(columnDefinition = "TEXT")
    private String street;
    @Getter
    @Setter
    private String number;
    @Getter
    @Setter
    private String district;
    @Getter
    @Setter
    private String city;
    @Getter
    @Setter
    private String state;

    @Getter
    @OneToMany
    private List<Appliance> applianceList;

    @Getter
    @OneToMany
    private List<Dependent> dependentList;
}
