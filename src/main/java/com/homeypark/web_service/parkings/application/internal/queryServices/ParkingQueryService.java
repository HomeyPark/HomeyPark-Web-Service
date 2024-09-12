package com.homeypark.web_service.parkings.application.internal.queryServices;

import com.homeypark.web_service.parkings.domain.model.entities.Parking;
import com.homeypark.web_service.parkings.domain.model.queries.GetAllParkingQuery;
import com.homeypark.web_service.parkings.domain.model.queries.GetParkingListByUserId;
import com.homeypark.web_service.parkings.domain.services.IParkingQueryService;
import com.homeypark.web_service.parkings.infrastructure.repositories.jpa.IParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingQueryService implements IParkingQueryService {
    @Autowired
    private IParkingRepository parkingRepository;

    @Override
    public List<Parking> handle(GetAllParkingQuery query) {
        return parkingRepository.findAll();
    }

    @Override
    public List<Parking> handle(GetParkingListByUserId query) {
        return parkingRepository.findByUserId(query.userId());
    }
}
