package com.homeypark.web_service.parkings.domain.services;

import com.homeypark.web_service.parkings.domain.model.entities.Parking;
import com.homeypark.web_service.parkings.domain.model.queries.GetAllParkingQuery;
import com.homeypark.web_service.parkings.domain.model.queries.GetParkingByIdQuery;

import java.util.List;
import java.util.Optional;

public interface IParkingQueryService {

    List<Parking> handle(GetAllParkingQuery query);
    Optional<Parking> handle(GetParkingByIdQuery query);
}
