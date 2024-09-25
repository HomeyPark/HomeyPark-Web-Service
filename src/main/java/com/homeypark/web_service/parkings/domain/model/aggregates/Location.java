package com.homeypark.web_service.parkings.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.homeypark.web_service.parkings.domain.model.commands.UpdateLocationCommand;
import com.homeypark.web_service.parkings.domain.model.entities.Parking;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Location")
public class Location {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "parking_id")
    @JsonBackReference
    private Parking parking;

    private String district;
    private String city;
    private String coordinates;
    private String typeDirection;
    private String numDirection;
    private String street;
    private String reference;


    public Location updateLocation(UpdateLocationCommand command){
        this.district = command.district();
        this.city= command.city();
        this.coordinates = command.coordinates();
        this.typeDirection = command.typeDirection();
        this.numDirection = command.numDirection();
        this.street = command.street();
        this.reference = command.reference();

        return this;
    }

}
