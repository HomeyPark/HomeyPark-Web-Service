package com.homeypark.web_service.parkings.domain.services;

import com.homeypark.web_service.parkings.domain.model.aggregates.Schedule;
import com.homeypark.web_service.parkings.domain.model.commands.UpdateScheduleCommand;

import java.util.Optional;

public interface IScheduleCommandService {
    Optional<Schedule> handle(UpdateScheduleCommand command);
}
