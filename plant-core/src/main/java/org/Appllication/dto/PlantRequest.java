package org.Appllication.dto;

import lombok.*;
import org.Appllication.enumeration.PlantType;

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
