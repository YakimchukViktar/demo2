package com.example.demo.dao.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "dispatchers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dispatcher extends BaseEntity {
    @Column(name = "last_name", nullable = false, length = 45)
    @Size(min = 2, max = 20, message = "errors.user.lastName")
    private String last_name;

    @Column(name = "second_name", length = 45, nullable = true)
    private String second_name;

    @Column(name = "first_name", nullable = false, length = 45)
    private String first_name;

    @OneToMany(mappedBy = "idDispatcher")
    private List<Trip> trips;

    @Override
    public String toString() {
        return last_name + " " + first_name;
    }

    @Column(unique = true, nullable = false)
    private String username;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$", message = "errors.user.password")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
