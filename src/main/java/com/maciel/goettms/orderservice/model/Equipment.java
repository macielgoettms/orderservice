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
public class Equipment {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private Customer customer;

    @NotBlank
    @Size(max = 128)
    private String description;

    @Size(max = 32)
    private String brand;

    @Size(max = 32)
    private String model;

    @Size(max = 64)
    private String identification;

}
