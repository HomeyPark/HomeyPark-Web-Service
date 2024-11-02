package com.homeypark.web_service.parkings.application.internal.queryServices;

import com.homeypark.web_service.parkings.domain.model.entities.Parking;
import com.homeypark.web_service.parkings.domain.model.queries.GetAllParkingQuery;
import com.homeypark.web_service.parkings.domain.model.queries.GetParkingByIdQuery;
import com.homeypark.web_service.parkings.domain.services.IParkingQueryService;
import com.homeypark.web_service.parkings.infrastructure.repositories.jpa.IParkingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingQueryService implements IParkingQueryService {
    private final IParkingRepository parkingRepository;


    public ParkingQueryService(IParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }


    @Override
    public List<Parking> handle(GetAllParkingQuery query) {
        return parkingRepository.findAll();
    }

    @Override
    public Optional<Parking> handle(GetParkingByIdQuery query) {
        return parkingRepository.findById(query.parkingId());
    }
}
