package com.homeypark.web_service.reservations.aplication.internal.commandServices;

import com.homeypark.web_service.reservations.domain.model.commands.CreateReservationCommand;
import com.homeypark.web_service.reservations.domain.model.entities.Reservation;
import com.homeypark.web_service.reservations.domain.services.IReservationCommandService;
import com.homeypark.web_service.reservations.infrastructure.repositories.jpa.IReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationCommandService implements IReservationCommandService {
    private final IReservationRepository reservationRepository;

    public ReservationCommandService(IReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Optional<Reservation> handle(CreateReservationCommand command) {
        var reservation = new Reservation(command);

        try {
            var response = reservationRepository.save(reservation);
            return Optional.of(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }
}
