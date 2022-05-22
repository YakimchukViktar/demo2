package com.example.demo.dao.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dispatchers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dispatcher extends BaseEntity{
    @Column (name = "last_name", nullable = false, length = 45)
    private String last_name;

    @Column (name = "second_name", length = 45)
    private String second_name;

    @Column (name = "first_name", nullable = false, length = 45)
    private String first_name;

    @OneToMany (mappedBy = "idDispatcher")
    private List <Trip> trips;

    @Override
    public String toString() {
        return last_name + " " + first_name;
    }

    @Column(unique = true)
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
