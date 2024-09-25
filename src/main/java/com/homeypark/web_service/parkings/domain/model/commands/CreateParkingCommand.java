package com.homeypark.web_service.parkings.domain.model.commands;

public record CreateParkingCommand(
        String address,
        double width,
        double length,
        double height,
        double price,
        String phone,
        String description,
        String district,
        String city,
        String coordinates,
        String typeDirection,
        String numDirection,
        String street,
        String reference
) {
}
