package com.homeypark.web_service.user.interfaces.rest;

import com.homeypark.web_service.user.application.internal.commandServices.VehicleCommandService;
import com.homeypark.web_service.user.application.internal.queryServices.VehicleQueryService;
import com.homeypark.web_service.user.domain.model.aggregates.Vehicle;
import com.homeypark.web_service.user.domain.model.entities.User;
import com.homeypark.web_service.user.domain.model.queries.GetAllVehiclesQuery;
import com.homeypark.web_service.user.domain.model.queries.GetUserByIdQuery;
import com.homeypark.web_service.user.domain.model.queries.GetVehicleByIdQuery;
import com.homeypark.web_service.user.interfaces.rest.resources.CreateVehicleResource;
import com.homeypark.web_service.user.interfaces.rest.transformers.CreateVehicleCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    private final VehicleQueryService vehicleQueryService;
    private final VehicleCommandService vehicleCommandService;

    public VehicleController(VehicleQueryService vehicleQueryService, VehicleCommandService vehicleCommandService) {
        this.vehicleQueryService = vehicleQueryService;
        this.vehicleCommandService = vehicleCommandService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        var getVehicleByIdQuery = new GetVehicleByIdQuery(id);

        var user = vehicleQueryService.handle(getVehicleByIdQuery);

        return user.map(u -> new ResponseEntity<>(u, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody CreateVehicleResource resource) {
        return vehicleCommandService.handle(CreateVehicleCommandFromResourceAssembler.toCommandFromResource(resource))
                .map(vehicle -> ResponseEntity.status(HttpStatus.CREATED).body(vehicle))
                .orElse(ResponseEntity.badRequest().build());
    }
}