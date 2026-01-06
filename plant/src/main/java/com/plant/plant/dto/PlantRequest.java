package com.plant.plant.dto;

import com.plant.plant.enumeration.PlantType;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PlantRequest implements Serializable {
    private PlantType type;
    private String name;
    private Boolean hasFlower;
    private String wateringPeriod;
    private String description;
    private String color;
    private Integer age;
    private Integer size;
}
