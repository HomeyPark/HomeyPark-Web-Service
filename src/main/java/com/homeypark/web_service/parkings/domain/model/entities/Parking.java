package com.homeypark.web_service.parkings.domain.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.homeypark.web_service.parkings.domain.model.aggregates.Location;
import com.homeypark.web_service.parkings.domain.model.aggregates.Schedule;
import com.homeypark.web_service.parkings.domain.model.commands.CreateParkingCommand;
import com.homeypark.web_service.parkings.domain.model.commands.UpdateLocationCommand;
import com.homeypark.web_service.parkings.domain.model.commands.UpdateParkingCommand;
import com.homeypark.web_service.reservations.domain.model.entities.Reservation;
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
    public Long id;
    public String address;
    public double width;
    public double length;
    public double height;
    public double price;
    public String phone;
    public String description;

    @OneToOne(mappedBy = "parking", cascade = CascadeType.ALL, optional = false)
    @JsonManagedReference
    private Location location;

    @OneToOne(mappedBy = "parking", cascade = CascadeType.ALL, optional = false)
    @JsonManagedReference
    private Schedule schedule;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn(name = "user_id", insertable = true, updatable = true)
    private User user;

    public Parking(CreateParkingCommand command) {
        this.address = command.address();
        this.width = command.width();
        this.length = command.length();
        this.height = command.height();
        this.price = command.price();
        this.phone = command.phone();
        this.description = command.description();

        //Location
        this.location = new Location();
        this.location.setDistrict(command.district());
        this.location.setCity(command.city());
        this.location.setCoordinates(command.coordinates());
        this.location.setTypeDirection(command.typeDirection());
        this.location.setNumDirection(command.numDirection());
        this.location.setStreet(command.street());
        this.location.setReference(command.reference());

        this.location.setParking(this);

        //Schedule
        this.schedule = new Schedule();
        this.schedule.setStartTime(command.startTime());
        this.schedule.setEndTime(command.endTime());

        this.schedule.setParking(this);


    }
    public Parking updatedParking(UpdateParkingCommand command){
        this.address = command.address();
        this.width = command.width();
        this.length = command.length();
        this.height = command.height();
        this.price = command.price();
        this.phone = command.phone();
        this.description = command.description();

        return this;
    }
}
