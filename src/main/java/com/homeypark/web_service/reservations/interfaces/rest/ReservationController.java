package com.homeypark.web_service.reservations.interfaces.rest;

import com.homeypark.web_service.reservations.aplication.internal.commandServices.ReservationCommandService;
import com.homeypark.web_service.reservations.domain.model.entities.Reservation;
import com.homeypark.web_service.reservations.interfaces.rest.resources.CreateReservationResource;
import com.homeypark.web_service.reservations.interfaces.rest.transformers.CreateReservationCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationController {
    private final ReservationCommandService reservationCommandService;


    public ReservationController(ReservationCommandService reservationCommandService) {
        this.reservationCommandService = reservationCommandService;
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody CreateReservationResource createReservationResource) {
        var createReservationCommand = CreateReservationCommandFromResourceAssembler.toCommandFromResource(createReservationResource);

        var reservation = reservationCommandService.handle(createReservationCommand);

        return reservation.map(r -> new ResponseEntity<>(r, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
