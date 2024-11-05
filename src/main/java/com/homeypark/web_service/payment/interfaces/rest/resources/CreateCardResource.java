package com.homeypark.web_service.payment.interfaces.rest.resources;

public record CreateCardResource(Long numCard, Long cvv, String date) {
}
