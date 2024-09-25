package com.homeypark.web_service.user.application.internal.commandServices;

import com.homeypark.web_service.user.domain.model.aggregates.Vehicle;
import com.homeypark.web_service.user.domain.model.commands.CreateVehicleCommand;
import com.homeypark.web_service.user.domain.model.entities.User;
import com.homeypark.web_service.user.domain.services.IVehicleCommandService;
import com.homeypark.web_service.user.infrastructure.repositories.jpa.IUserRepository;
import com.homeypark.web_service.user.infrastructure.repositories.jpa.IVehicleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleCommandService implements IVehicleCommandService {

    private final IVehicleRepository vehicleRepository;
    private final IUserRepository userRepository;

    public VehicleCommandService(IVehicleRepository vehicleRepository, IUserRepository userRepository) {
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Vehicle> handle(CreateVehicleCommand command) {
        Optional<User> user = userRepository.findById(command.userId());

        if (user.isPresent()) {
            // Crear un nuevo vehículo usando el constructor que acepta CreateVehicleCommand
            Vehicle vehicle = new Vehicle(command, user.get());
            var response = vehicleRepository.save(vehicle);
            return Optional.of(response);
        }
        return Optional.empty();
    }
}