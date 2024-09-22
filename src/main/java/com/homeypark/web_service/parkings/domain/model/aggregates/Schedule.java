package com.homeypark.web_service.parkings.domain.model.aggregates;

import com.homeypark.web_service.parkings.domain.model.commands.UpdateScheduleCommand;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String startTime;

    private String endTime;

    public Schedule updatedSchedule(UpdateScheduleCommand command){
        this.startTime = command.startTime();
        this.endTime = command.endTime();
        return this;
    }

}
