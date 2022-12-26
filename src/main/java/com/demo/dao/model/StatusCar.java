package com.demo.dao.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "statuses_car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusCar extends BaseEntity {

    @Column(name = "status", length = 45)
    private String status;

    @OneToMany(mappedBy = "idStatus")
    private List<Car> cars;

    @Override
    public String toString() {
        return status;
    }
}