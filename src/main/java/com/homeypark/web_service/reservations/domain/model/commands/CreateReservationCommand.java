package com.homeypark.web_service.reservations.domain.model.commands;

import java.time.LocalDateTime;

public record CreateReservationCommand(
        Integer hoursRegistered,
        Double totalFare,
        LocalDateTime startTime,
        LocalDateTime endTime,
        String status
) {}
