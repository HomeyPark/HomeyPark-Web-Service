package com.homeypark.web_service.parkings.domain.services;

import com.homeypark.web_service.parkings.domain.model.entities.Parking;
import com.homeypark.web_service.parkings.domain.model.queries.GetAllParkingQuery;

import java.util.List;

public interface IParkingQueryService {

    List<Parking> handle(GetAllParkingQuery query);
}
