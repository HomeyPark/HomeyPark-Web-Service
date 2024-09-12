package com.homeypark.web_service.reservations.domain.model.entities;

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
}
