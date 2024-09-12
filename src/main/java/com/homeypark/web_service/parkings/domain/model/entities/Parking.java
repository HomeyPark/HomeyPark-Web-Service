package com.homeypark.web_service.parkings.domain.model.entities;

import com.homeypark.web_service.parkings.domain.model.commands.CreateParkingCommand;
import com.homeypark.web_service.user.domain.model.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "parkings")
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private double width;
    private double length;
    private double height;
    private double price;
    private String phone;
    private String description;
    private double latitude;
    private double longitude;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;


    public Parking(CreateParkingCommand command) {
        this.address = command.address();
        this.width = command.width();
        this.length = command.length();
        this.height = command.height();
        this.price = command.price();
        this.phone = command.phone();
        this.description = command.description();
        this.latitude = command.latitude();
        this.longitude = command.longitude();
    }
}
