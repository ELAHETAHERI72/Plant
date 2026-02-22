package org.Appllication.mapper;

import org.Appllication.domain.Plant;
import org.Appllication.dto.PlantRequest;
import org.Appllication.dto.PlantResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = GlobalConfig.class)
public interface PlantMapper {

    @Mapping(target = "updateDate", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    Plant toDomain(PlantRequest model);

    Plant PlantResToPlant(PlantResponse model);

    PlantResponse plantToResponse(Plant plant);
}

//اگر مدل و dto متفاوت باشد این مدلی بهم باید مپشوم کنیم :

//import org.mapstruct.*;
//        import org.mapstruct.factory.Mappers;
//
//@Mapper(uses = {DateMapper.class}, config = MapStructConfig.class)
//public interface UserMapper {
//
//    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
//
//    @Mapping(source = "fullName", target = "name")
//    @Mapping(source = "userDetails.email", target = "email")
//    @Mapping(target = "status", constant = "ACTIVE")
//    @Mapping(target = "createdAt", expression = "java(new java.util.Date())")
//    UserDto toDto(UserEntity entity);
//
//    @InheritInverseConfiguration
//    UserEntity toEntity(UserDto dto);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void updateEntity(UserDto dto, @MappingTarget UserEntity entity);
//
//    // Collection mappings
//    List<UserDto> toDtoList(List<UserEntity> entities);
//}