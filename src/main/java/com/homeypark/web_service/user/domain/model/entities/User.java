package com.homeypark.web_service.user.domain.model.entities;

import com.homeypark.web_service.user.domain.model.commands.CreateUserCommand;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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


    public User(String email, Long id, String lastName, String name, String password) {
        this.id = id;
        this.email = email;
        this.lastName = lastName;
        this.name = name;
        this.password = password;
    }

    public User(CreateUserCommand command) {
        this.name = command.name();
        this.lastName = command.lastName();
        this.email = command.email();
        this.password = command.password();
    }
}
