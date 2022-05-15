package com.example.demo.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table (name = "drivers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Driver extends BaseEntity{

    @Column(name = "last_name", length = 45, nullable = false)
    private String last_name;

    @Column(name = "second_name", length = 45)
    private String second_name;

    @Column(name = "first_name", length = 45, nullable = false)
    private String first_name;

    @Column(name = "is_in_trip", nullable = false)
    private int isInTrip;

    @Column(name = "is_active", nullable = false)
    private int isActive;

    @OneToMany (mappedBy = "idDriver")
    private List<Trip> trips;

    @Override
    public String toString() {
        return last_name + " "+first_name;
    }
}
