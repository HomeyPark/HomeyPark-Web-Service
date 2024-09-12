package com.homeypark.web_service.reservations.domain.model.entities;

import com.homeypark.web_service.reservations.domain.model.commands.CreateReservationCommand;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer hoursRegistered;
    private Double totalFare;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;

    public Reservation(CreateReservationCommand command) {
        this.hoursRegistered = command.hoursRegistered();
        this.totalFare = command.totalFare();
        this.startTime = command.startTime();
        this.endTime = command.endTime();
        this.status = command.status();
    }
}
