package com.homeypark.web_service.reservations.domain.model.commands;

import com.homeypark.web_service.reservations.domain.model.valueobject.Status;

import java.time.LocalDateTime;

public record CreateReservationCommand(
        Integer hoursRegistered,
        Double totalFare,
        LocalDateTime startTime,
        LocalDateTime endTime
) {}
