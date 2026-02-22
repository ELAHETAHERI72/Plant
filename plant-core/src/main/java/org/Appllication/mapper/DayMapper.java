package org.Appllication.mapper;

import org.Appllication.enumeration.Day;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = GlobalConfig.class)
public interface DayMapper {
    Day persianToEnum(String day);

}
