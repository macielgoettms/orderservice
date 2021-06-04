package com.maciel.goettms.orderservice.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "order", schema = "public")
@Data
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 128)
    private String description;

    @ManyToOne
    private Equipment equipment;

    @Size(max = 256)
    private String diagnostic;

    @Size(max = 256)
    private String solution;

    private Timestamp estimated;

}
