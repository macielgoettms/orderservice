package com.maciel.goettms.orderservice.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Customer {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 128)
    private String name;

    @Size(max = 32)
    @Column(name = "identification")
    private String identificationNumber;

    @Size(max = 32)
    private String phone;

    @Size(max = 128)
    private String address;

    @Size(max = 64)
    private String city;

    @Size(max = 32)
    private String state;

}
