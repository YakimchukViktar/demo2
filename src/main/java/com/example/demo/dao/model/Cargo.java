package com.example.demo.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cargos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cargo extends BaseEntity{

    @Column(name = "invoice_number")
    private Integer invoiceNumber;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "insurance_number")
    private Integer insuranceNumber;

    @OneToMany(mappedBy = "idCargo")
    private List<Trip> trips;

    @Override
    public String toString() {
        return name;
    }
}