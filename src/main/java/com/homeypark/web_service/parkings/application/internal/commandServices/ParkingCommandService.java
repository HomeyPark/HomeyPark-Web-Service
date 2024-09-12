package com.homeypark.web_service.parkings.application.internal.commandServices;

import com.homeypark.web_service.parkings.domain.model.commands.CreateParkingCommand;
import com.homeypark.web_service.parkings.domain.model.entities.Parking;
import com.homeypark.web_service.parkings.domain.services.IParkingCommandService;
import com.homeypark.web_service.parkings.infrastructure.repositories.jpa.IParkingRepository;
import com.homeypark.web_service.user.domain.model.entities.User;
import com.homeypark.web_service.user.infrastructure.repositories.jpa.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParkingCommandService implements IParkingCommandService {
    private final IParkingRepository parkingRepository;
    private final IUserRepository userRepository;

    public ParkingCommandService(IParkingRepository parkingRepository, IUserRepository userRepository) {
        this.parkingRepository = parkingRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Optional<Parking> handle(CreateParkingCommand command) {
        Optional<User> user = userRepository.findById(command.userId());

        if (user.isEmpty()) return Optional.empty();

        Parking parking = new Parking(command);
        parking.setUser(user.get());

        System.out.println("DEBUG" + parking.getUser());
        System.out.println("DEBUG" + parking);

        user.get().getParkings().add(parking);



        try{
            var response = parkingRepository.save(parking);
            return Optional.of(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }
}
