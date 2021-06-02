package com.maciel.goettms.orderservice.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "equipment", schema = "public")
@Data
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
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
