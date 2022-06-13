package com.example.demo.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table (name = "drivers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Driver extends BaseEntity{

    @Column(name = "last_name", length = 45, nullable = false)
    @Size(min = 0, max = 45, message = "errors.user.lastName")
    private String last_name;

    @Column(name = "second_name", length = 45)
    private String second_name;

    @Column(name = "first_name", length = 45, nullable = false)
    private String first_name;

    @Column(name = "is_in_trip", nullable = false)
    private int isInTrip;

    @Column(name = "is_active", nullable = false)
    private int isActive;

    @Column(unique = true, nullable = false)
    private String username;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$", message = "errors.user.password")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany (mappedBy = "idDriver")
    private List<Trip> trips;

    @Override
    public String toString() {
        return last_name + " "+first_name;
    }
}
