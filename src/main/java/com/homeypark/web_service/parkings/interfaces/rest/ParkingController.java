package com.homeypark.web_service.parkings.interfaces.rest;

import com.homeypark.web_service.parkings.application.internal.commandServices.ParkingCommandService;
import com.homeypark.web_service.parkings.application.internal.queryServices.ParkingQueryService;
import com.homeypark.web_service.parkings.domain.model.entities.Parking;
import com.homeypark.web_service.parkings.domain.model.queries.GetAllParkingQuery;
import com.homeypark.web_service.parkings.domain.model.queries.GetParkingListByUserId;
import com.homeypark.web_service.parkings.interfaces.rest.resources.CreateParkingResource;
import com.homeypark.web_service.parkings.interfaces.rest.resources.ParkingResource;
import com.homeypark.web_service.parkings.interfaces.rest.transformers.CreateParkingCommandFromResourceAssembler;
import com.homeypark.web_service.parkings.interfaces.rest.transformers.ParkingResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/parking")
public class ParkingController {
    private final ParkingCommandService parkingCommandService;
    private final ParkingQueryService parkingQueryService;


    public ParkingController(ParkingCommandService parkingCommandService, ParkingQueryService parkingQueryService) {
        this.parkingCommandService = parkingCommandService;
        this.parkingQueryService = parkingQueryService;
    }

    @GetMapping
    public ResponseEntity<List<ParkingResource>> getAllParking() {
        var getAllParkingQuery = new GetAllParkingQuery();
        var parkingList = parkingQueryService.handle(getAllParkingQuery);

        return new ResponseEntity<>(parkingList.stream().map(ParkingResourceFromEntityAssembler::toResourceFromEntity).toList(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<ParkingResource>> getParkingListByUserId(@PathVariable("id") Long id) {
        var getParkingListByUserIdQuery = new GetParkingListByUserId(id);
        var parkingList = parkingQueryService.handle(getParkingListByUserIdQuery);

        return new ResponseEntity<>(parkingList.stream().map(ParkingResourceFromEntityAssembler::toResourceFromEntity).toList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ParkingResource> createUser(@RequestBody CreateParkingResource createParkingResource) {
        var createParkingCommand = CreateParkingCommandFromResourceAssembler.toCommandFromResource(createParkingResource);

        var parking = parkingCommandService.handle(createParkingCommand);

        return parking.map(p -> new ResponseEntity<>(ParkingResourceFromEntityAssembler.toResourceFromEntity(p), HttpStatus.CREATED)).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
