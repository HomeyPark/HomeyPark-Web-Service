package com.homeypark.web_service.parkings.interfaces.rest.resources;

public record UpdateParkingResource(String address,
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
                                    String reference,
                                    String startTime,
                                    String endTime) {
}
