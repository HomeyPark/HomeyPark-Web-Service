package com.homeypark.web_service.user.domain.model.entities;

import com.homeypark.web_service.user.domain.model.aggregates.Vehicle;
import com.homeypark.web_service.user.domain.model.commands.CreateUserCommand;
import com.homeypark.web_service.user.domain.model.commands.UpdateUserCommand;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private ArrayList<Vehicle> vehicles;


    public User(String email, Long id, String lastName, String name, String password) {
        this.id = id;
        this.email = email;
        this.lastName = lastName;
        this.name = name;
        this.password = password;
        this.vehicles = new ArrayList<>();
    }

    public User(CreateUserCommand command) {
        this.name = command.name();
        this.lastName = command.lastName();
        this.email = command.email();
        this.password = command.password();
        this.vehicles = new ArrayList<>();
    }

    public User updatedUser(UpdateUserCommand command) {
        this.name = command.name();
        this.lastName = command.lastName();
        this.email = command.email();
        this.password = command.password();
        return this;
    }
}
