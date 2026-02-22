package org.Appllication.dto.projection;

import java.time.ZonedDateTime;

public interface PlantProjection {
    Boolean getHasFlower();

    String getName();

    String getColor();

    String getWateringPeriod();

    String getDescription();

    ZonedDateTime getCreateDate();

    Integer getAge();

    Integer getSize();
}
