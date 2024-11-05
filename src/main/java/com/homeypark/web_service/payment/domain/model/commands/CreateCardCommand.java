package com.homeypark.web_service.payment.domain.model.commands;

public record CreateCardCommand(Long numCard, Long cvv, String date) {
}
