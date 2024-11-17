package com.homeypark.web_service.shared.config.seeders;

import com.homeypark.web_service.parkings.domain.model.commands.CreateParkingCommand;
import com.homeypark.web_service.parkings.domain.model.entities.Parking;
import com.homeypark.web_service.parkings.infrastructure.repositories.jpa.IParkingRepository;
import com.homeypark.web_service.user.domain.model.commands.CreateUserCommand;
import com.homeypark.web_service.user.domain.model.entities.User;
import com.homeypark.web_service.user.infrastructure.repositories.jpa.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final IUserRepository userRepository;
    private final IParkingRepository parkingRepository;

    public DataSeeder(IUserRepository userRepository, IParkingRepository parkingRepository) {
        this.userRepository = userRepository;
        this.parkingRepository = parkingRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User user1 = userRepository.save(new User(new CreateUserCommand("Marcelo Fabian", "Garro Vega", "marcelogarro137@gmail.com", "admin123")));

            User user2 = userRepository.save(new User(new CreateUserCommand("Daniel", "Chirinos", "daniel@gmail.com", "admin123")));

            User user3 = userRepository.save(new User(new CreateUserCommand("George", "Aliaga", "george@gmail.com", "admin123")));

            User user4= userRepository.save(new User(new CreateUserCommand("Vitorio", "Eduardo", "marcelogarro137@gmail.com", "admin123")));

            System.out.println("Users created");
            System.out.println(user1.getId());

            Parking parking1 = new Parking(new CreateParkingCommand(user1.getId(), 23.5, 24.2, 40.8, 100.0, "958872689", 14, "This is the best place to leave your car and stay in calm", "Av. General Recavarren", "1300", "Surquillo", "Lima", "Lima", -12.107520, -77.024040));

            Parking parking2 = new Parking(new CreateParkingCommand(user2.getId(), 20.0, 22.0, 35.0, 80.0, "958872690", 10, "Secure parking space in the heart of the city", "Av. Pardo y Aliaga", "640", "San Isidro", "Lima", "Lima", -12.097520, -77.034040));

            Parking parking3 = new Parking(new CreateParkingCommand(user3.getId(), 25.0, 26.0, 45.0, 120.0, "958872691", 20, "Spacious parking with 24/7 security", "Av. Javier Prado", "5600", "La Molina", "Lima", "Lima", -12.087520, -77.044040));

            Parking parking4 = new Parking(new CreateParkingCommand(user4.getId(), 22.0, 24.0, 38.0, 90.0, "958872692", 12, "Affordable parking near the shopping center", "Av. Angamos", "1500", "Miraflores", "Lima", "Lima", -12.077520, -77.054040));

            parking1.setUser(user1);
            parking2.setUser(user2);
            parking3.setUser(user3);
            parking4.setUser(user4);

            parkingRepository.save(parking1);
            parkingRepository.save(parking2);
            parkingRepository.save(parking3);
            parkingRepository.save(parking4);
        }
    }
}
