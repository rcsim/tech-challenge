package br.com.postech30.challenge.entity;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
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

    @Getter
    @Setter
    @ManyToOne
    private Address address;

}