package com.homeypark.web_service.parkings.interfaces.rest.resources;

public record UpdateParkingResource(String address,
                                    double width,
                                    double length,
                                    double height,
                                    double price,
                                    String phone,
                                    String description,
                                    double latitude,
                                    double longitude) {
}
