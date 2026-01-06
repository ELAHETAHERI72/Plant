package com.plant.plant.dto;

import com.plant.plant.enumeration.PlantType;
import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlantAdvanceSearch implements Serializable {
    private String name;
    private PlantType type;
    private Boolean hasFlower;
    private String wateringPeriod;
    private String description;
    private String color;
    private Integer age;
    private Integer size;
    private ZonedDateTime fromDate;
    private ZonedDateTime toDate;
}
