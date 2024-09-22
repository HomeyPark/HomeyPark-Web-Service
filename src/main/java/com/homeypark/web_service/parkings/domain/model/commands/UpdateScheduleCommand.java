package com.homeypark.web_service.parkings.domain.model.commands;

public record UpdateScheduleCommand(Long scheduleId, String startTime, String endTime) {
}
