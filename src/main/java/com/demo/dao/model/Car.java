package com.demo.dao.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car extends BaseEntity {

    @Column(name = "brand", nullable = false, length = 45)
    @Size(min = 2, max = 20, message = "errors.user.brand")
    private String brand;

    @Column(name = "number", nullable = false, length = 45)
    private String number;

    @Column(name = "mileage", nullable = false)
    private Integer mileage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status")
    private StatusCar idStatus;

    @OneToMany(mappedBy = "idCar")
    private List<Trip> trips;

    @Override
    public String toString() {
        return brand + " " + number;
    }
}