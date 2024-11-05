package com.homeypark.web_service.parkings.interfaces.rest;

import com.homeypark.web_service.parkings.application.internal.commandServices.ScheduleCommandService;
import com.homeypark.web_service.parkings.application.internal.queryServices.ScheduleQueryService;
import com.homeypark.web_service.parkings.domain.model.aggregates.Location;
import com.homeypark.web_service.parkings.domain.model.aggregates.Schedule;
import com.homeypark.web_service.parkings.domain.model.queries.GetAllLocationsQuery;
import com.homeypark.web_service.parkings.domain.model.queries.GetAllScheduleQuery;
import com.homeypark.web_service.parkings.interfaces.rest.resources.UpdateScheduleResource;
import com.homeypark.web_service.parkings.interfaces.rest.transformers.UpdateScheduleCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/schedule")
@Tag(name="Schedule", description = "Schedule Management Endpoints")
public class ScheduleController {
    private final ScheduleCommandService scheduleCommandService;
    private final ScheduleQueryService scheduleQueryService;


    public ScheduleController(ScheduleCommandService scheduleCommandService, ScheduleQueryService scheduleQueryService) {
        this.scheduleCommandService = scheduleCommandService;
        this.scheduleQueryService = scheduleQueryService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody UpdateScheduleResource updateScheduleResource){

        var updateScheduleCommand = UpdateScheduleCommandFromResourceAssembler.toCommandFromResource(id, updateScheduleResource);

        var updatedSchedule = scheduleCommandService.handle(updateScheduleCommand);

        return updatedSchedule.map(p -> new ResponseEntity<>(p, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping
    public ResponseEntity<List<Schedule>> getAllSchedule(){
        var getAllScheduleQuery = new GetAllScheduleQuery();
        var scheduleList = scheduleQueryService.handle(getAllScheduleQuery);
        return new ResponseEntity<>(scheduleList, HttpStatus.OK);
    }
}