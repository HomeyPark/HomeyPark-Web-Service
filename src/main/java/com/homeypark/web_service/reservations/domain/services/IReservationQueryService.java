package com.homeypark.web_service.reservations.domain.services;

import com.homeypark.web_service.reservations.domain.model.entities.Reservation;
import com.homeypark.web_service.reservations.domain.model.queries.GetReservationByIdQuery;

import java.util.Optional;

public interface IReservationQueryService {
    Optional<Reservation> handle(GetReservationByIdQuery query);
}
