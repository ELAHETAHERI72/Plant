package org.Appllication.mapper;

import org.Appllication.beans.TrimmerMapper;
import org.mapstruct.MapperConfig;

@MapperConfig(componentModel = "spring", uses = {TrimmerMapper.class})
public interface GlobalConfig {
}
