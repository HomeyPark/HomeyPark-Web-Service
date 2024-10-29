package com.homeypark.web_service.reservations.interfaces.rest;

import com.homeypark.web_service.parkings.domain.model.entities.Parking;
import com.homeypark.web_service.reservations.aplication.internal.commandServices.ReservationCommandService;
import com.homeypark.web_service.reservations.aplication.internal.queryServices.ReservationQueryService;
import com.homeypark.web_service.reservations.domain.model.entities.Reservation;
import com.homeypark.web_service.reservations.domain.model.queries.*;
import com.homeypark.web_service.reservations.interfaces.rest.resources.CreateReservationResource;
import com.homeypark.web_service.reservations.interfaces.rest.resources.UpdateReservationResource;
import com.homeypark.web_service.reservations.interfaces.rest.transformers.CreateReservationCommandFromResourceAssembler;
import com.homeypark.web_service.reservations.interfaces.rest.transformers.UpdateReservationCommandFromResource;
import com.homeypark.web_service.user.domain.model.queries.GetUserByIdQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationController {
    private final ReservationCommandService reservationCommandService;
    private final ReservationQueryService reservationQueryService;


    public ReservationController(ReservationCommandService reservationCommandService, ReservationQueryService reservationQueryService) {
        this.reservationCommandService = reservationCommandService;
        this.reservationQueryService = reservationQueryService;
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations(){
     var getAllReservationsQuery = new GetAllReservationsQuery();
     var reservationList = reservationQueryService.handle(getAllReservationsQuery);
     return new ResponseEntity<>(reservationList,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody CreateReservationResource createReservationResource) {
        var createReservationCommand = CreateReservationCommandFromResourceAssembler.toCommandFromResource(createReservationResource);

        var reservation = reservationCommandService.handle(createReservationCommand);

        return reservation.map(r -> new ResponseEntity<>(r, HttpStatus.CREATED)).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody UpdateReservationResource updateReservationResource) {
        var updateReservationCommand = UpdateReservationCommandFromResource.toCommandFromResource(id, updateReservationResource);
        var updatedReservation = reservationCommandService.handle(updateReservationCommand);
        return updatedReservation.map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") Long id) {
        var getReservationByIdQuery = new GetReservationByIdQuery(id);

        var reservation = reservationQueryService.handle(getReservationByIdQuery);

        return reservation.map(r -> new ResponseEntity<>(r, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/pending")
    public ResponseEntity<List<Reservation>> getPendingReservation(){
        var getPendingReservationQuery = new GetPendingReservationQuery();
        var pendingList = reservationQueryService.handle(getPendingReservationQuery);
        return new ResponseEntity<>(pendingList,HttpStatus.OK);
    }
    @GetMapping("/inProgress")
    public ResponseEntity<List<Reservation>> getInProgressReservation(){
        var getInProgressReservationQuery = new GetInProgressReservationQuery();
        var inProgressList = reservationQueryService.handle(getInProgressReservationQuery);
        return new ResponseEntity<>(inProgressList,HttpStatus.OK);
    }
    @GetMapping("/upComing")
    public ResponseEntity<List<Reservation>> getUpComingReservation(){
        var getUpComingReservationQuery = new GetUpComingReservationQuery();
        var upComingList = reservationQueryService.handle(getUpComingReservationQuery);
        return new ResponseEntity<>(upComingList,HttpStatus.OK);
    }
}
