package com.homeypark.web_service.reservations.aplication.internal.queryServices;

import com.homeypark.web_service.reservations.domain.model.entities.Reservation;
import com.homeypark.web_service.reservations.domain.model.queries.*;
import com.homeypark.web_service.reservations.domain.model.valueobject.Status;
import com.homeypark.web_service.reservations.domain.services.IReservationQueryService;
import com.homeypark.web_service.reservations.infrastructure.repositories.jpa.IReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationQueryService implements IReservationQueryService {

    private final IReservationRepository reservationRepository;

    public ReservationQueryService(IReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> handle(GetAllReservationsQuery query) {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> handle(GetReservationByIdQuery query) {
        return reservationRepository.findById(query.reservationId());
    }

    @Override
    public List<Reservation> handle(GetInProgressReservationQuery query) {
        return reservationRepository.findByStatus(Status.InProgress);
    }

    @Override
    public List<Reservation> handle(GetUpComingReservationQuery query) {
        return reservationRepository.findByStatus(Status.UpComing);
    }

    @Override
    public List<Reservation> handle(GetPendingReservationQuery query) {
        return reservationRepository.findByStatus(Status.Pending);
    }
}
