package br.com.postech30.challenge.entity;

import javax.persistence.*;
import lombok.*;

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
    private String estate;
}
