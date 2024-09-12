package com.homeypark.web_service.reservations.domain.services;

import com.homeypark.web_service.reservations.domain.model.commands.CreateReservationCommand;
import com.homeypark.web_service.reservations.domain.model.entities.Reservation;

import java.util.Optional;

public interface IReservationCommandService {
    Optional<Reservation> handle(CreateReservationCommand command);
}
