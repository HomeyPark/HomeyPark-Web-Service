package com.homeypark.web_service.user.interfaces.rest.resources;

import com.homeypark.web_service.user.domain.model.aggregates.Vehicle;

import java.util.List;

public record CreateUserResource(
        String name,
        String lastName,
        String email,
        String password,
        List<Vehicle> vehicles
) {
}
