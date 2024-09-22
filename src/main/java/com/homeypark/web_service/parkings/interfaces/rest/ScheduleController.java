package com.homeypark.web_service.parkings.interfaces.rest;

import com.homeypark.web_service.parkings.application.internal.commandServices.ScheduleCommandService;
import com.homeypark.web_service.parkings.domain.model.aggregates.Schedule;
import com.homeypark.web_service.parkings.interfaces.rest.resources.UpdateScheduleResource;
import com.homeypark.web_service.parkings.interfaces.rest.transformers.UpdateScheduleCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/schedule")
@Tag(name="Schedule", description = "Schedule Management Endpoints")
public class ScheduleController {
    private final ScheduleCommandService scheduleCommandService;

    public ScheduleController(ScheduleCommandService scheduleCommandService) {
        this.scheduleCommandService = scheduleCommandService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody UpdateScheduleResource updateScheduleResource){

        var updateScheduleCommand = UpdateScheduleCommandFromResourceAssembler.toCommandFromResource(id, updateScheduleResource);

        var updatedSchedule = scheduleCommandService.handle(updateScheduleCommand);

        return updatedSchedule.map(p -> new ResponseEntity<>(p, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
