package com.homeypark.web_service.parkings.application.internal.queryServices;

import com.homeypark.web_service.parkings.domain.model.aggregates.Location;
import com.homeypark.web_service.parkings.domain.model.queries.GetAllLocationsQuery;
import com.homeypark.web_service.parkings.domain.model.queries.GetLocationsByNearLatLngQuery;
import com.homeypark.web_service.parkings.domain.services.ILocationQueryService;
import com.homeypark.web_service.parkings.infrastructure.repositories.jpa.ILocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationQueryService implements ILocationQueryService {

    private final ILocationRepository locationRepository;

    public LocationQueryService(ILocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> handle(GetAllLocationsQuery query) {
        return locationRepository.findAll();
    }

    @Override
    public List<Location> handle(GetLocationsByNearLatLngQuery query) {
        List<Location> locationList = locationRepository.findAll();

        locationList.removeIf(location -> {
            double earthRadius = 6371; // Radio de la Tierra en kilómetros
            double dLat = Math.toRadians(location.getLatitude() - query.latitude());
            double dLng = Math.toRadians(location.getLongitude() - query.longitude());
            double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                    Math.cos(Math.toRadians(query.latitude())) * Math.cos(Math.toRadians(location.getLatitude())) *
                            Math.sin(dLng / 2) * Math.sin(dLng / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double distance = earthRadius * c;
            return distance > 1;
        });
        return locationList;
    }
}
