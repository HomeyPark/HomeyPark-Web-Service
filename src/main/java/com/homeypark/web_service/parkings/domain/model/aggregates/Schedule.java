package com.homeypark.web_service.parkings.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.homeypark.web_service.parkings.domain.model.commands.UpdateScheduleCommand;
import com.homeypark.web_service.parkings.domain.model.entities.Parking;
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

    @OneToOne
    @MapsId
    @JoinColumn(name = "parking_id")
    @JsonBackReference
    private Parking parking;

    private String startTime;

    private String endTime;

    public Schedule updatedSchedule(UpdateScheduleCommand command){
        this.startTime = command.startTime();
        this.endTime = command.endTime();
        return this;
    }

}
