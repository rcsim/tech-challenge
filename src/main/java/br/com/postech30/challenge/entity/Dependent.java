package br.com.postech30.challenge.entity;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;

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

}