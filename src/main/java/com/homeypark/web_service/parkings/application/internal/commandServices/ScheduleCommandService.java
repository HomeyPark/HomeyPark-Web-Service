package com.homeypark.web_service.parkings.application.internal.commandServices;

import com.homeypark.web_service.parkings.domain.model.aggregates.Schedule;
import com.homeypark.web_service.parkings.domain.model.commands.UpdateParkingCommand;
import com.homeypark.web_service.parkings.domain.model.commands.UpdateScheduleCommand;
import com.homeypark.web_service.parkings.domain.model.entities.Parking;
import com.homeypark.web_service.parkings.domain.services.IScheduleCommandService;
import com.homeypark.web_service.parkings.infrastructure.repositories.jpa.IScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScheduleCommandService implements IScheduleCommandService {
    private final IScheduleRepository scheduleRepository;

    public ScheduleCommandService(IScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Optional<Schedule> handle(UpdateScheduleCommand command) {
        var result = scheduleRepository.findById(command.scheduleId());
        if (result.isEmpty())
            throw new IllegalArgumentException("Schedule does not exist");
        var scheduleToUpdate = result.get();
        try{
            var updatedSchedule= scheduleRepository.save(scheduleToUpdate.updatedSchedule(command));
            return Optional.of(updatedSchedule);
        } catch (Exception e){
            throw new IllegalArgumentException("Error while updating schedule: " + e.getMessage());
        }

    }
}
