package br.com.postech30.challenge.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    private LocalDate dateOfBirth;
    private String gender;
    private String parentage;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    private Long userId;

}