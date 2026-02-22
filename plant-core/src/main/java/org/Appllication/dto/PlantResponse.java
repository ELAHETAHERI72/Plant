package org.Appllication.dto;

import org.Appllication.enumeration.PlantType;
import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PlantResponse  implements Serializable {
    private PlantType type;
    private String name;
    private Boolean hasFlower;
    private String wateringPeriod;
    private String description;
    private String color;
    private Integer age;
    private Integer size;
    private ZonedDateTime createDate;
    private ZonedDateTime updateDate;
    private Long id;

}
