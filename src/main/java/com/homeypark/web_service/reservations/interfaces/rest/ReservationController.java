package com.homeypark.web_service.reservations.interfaces.rest;

import com.homeypark.web_service.reservations.aplication.internal.commandServices.ReservationCommandService;
import com.homeypark.web_service.reservations.aplication.internal.queryServices.ReservationQueryService;
import com.homeypark.web_service.reservations.domain.model.entities.Reservation;
import com.homeypark.web_service.reservations.domain.model.queries.GetReservationByIdQuery;
import com.homeypark.web_service.reservations.interfaces.rest.resources.CreateReservationResource;
import com.homeypark.web_service.reservations.interfaces.rest.transformers.CreateReservationCommandFromResourceAssembler;
import com.homeypark.web_service.user.domain.model.queries.GetUserByIdQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationController {
    private final ReservationCommandService reservationCommandService;
    private final ReservationQueryService reservationQueryService;


    public ReservationController(ReservationCommandService reservationCommandService, ReservationQueryService reservationQueryService) {
        this.reservationCommandService = reservationCommandService;
        this.reservationQueryService = reservationQueryService;
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody CreateReservationResource createReservationResource) {
        var createReservationCommand = CreateReservationCommandFromResourceAssembler.toCommandFromResource(createReservationResource);

        var reservation = reservationCommandService.handle(createReservationCommand);

        return reservation.map(r -> new ResponseEntity<>(r, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") Long id) {
        var getReservationByIdQuery = new GetReservationByIdQuery(id);

        var reservation = reservationQueryService.handle(getReservationByIdQuery);

        return reservation.map(r -> new ResponseEntity<>(r, HttpStatus.OK)).orElse(ResponseEntity.notFound().build());
    }
}
