package com.homeypark.web_service.user.domain.services;

import com.homeypark.web_service.user.domain.model.aggregates.Vehicle;
import com.homeypark.web_service.user.domain.model.commands.CreateVehicleCommand;

import java.util.Optional;

public interface IVehicleCommandService {
    Optional<Vehicle> handle(CreateVehicleCommand command);
}