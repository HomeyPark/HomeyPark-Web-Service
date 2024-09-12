package com.homeypark.web_service.reservations.aplication.internal.queryServices;

import com.homeypark.web_service.reservations.domain.model.entities.Reservation;
import com.homeypark.web_service.reservations.domain.model.queries.GetReservationByIdQuery;
import com.homeypark.web_service.reservations.domain.services.IReservationQueryService;
import com.homeypark.web_service.reservations.infrastructure.repositories.jpa.IReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationQueryService implements IReservationQueryService {

    private final IReservationRepository reservationRepository;

    public ReservationQueryService(IReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Optional<Reservation> handle(GetReservationByIdQuery query) {
        return reservationRepository.findById(query.reservationId());
    }
}
