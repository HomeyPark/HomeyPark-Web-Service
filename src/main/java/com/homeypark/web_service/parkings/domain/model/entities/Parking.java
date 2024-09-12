package com.homeypark.web_service.parkings.domain.model.entities;

import com.homeypark.web_service.parkings.domain.model.commands.CreateParkingCommand;
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
    public Long id;
    public String address;
    public double width;
    public double length;
    public double height;
    public double price;
    public String phone;
    public String description;
    public double latitude;
    public double longitude;

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
