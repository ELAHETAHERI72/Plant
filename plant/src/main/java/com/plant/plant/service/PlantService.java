package com.plant.plant.service;

import com.plant.plant.domain.Plant;
import com.plant.plant.dto.PlantAdvanceSearch;
import com.plant.plant.dto.PlantRequest;
import com.plant.plant.dto.PlantResponse;
import com.plant.plant.dto.projection.PlantProjection;
import com.plant.plant.enumeration.PlantType;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;


public interface PlantService {
    PlantResponse create(PlantRequest model);

    void update(PlantRequest model, Long id);

    void delete(Long id);

    List<Plant> getByAge(Integer age);

    List<Plant> getAll();

    List<Plant> findByAgeBetween(Integer startAge, Integer endAge);

    Page<Plant> getAllByCreateDateRangeOrderByCreateDateDesc(ZonedDateTime startDate, ZonedDateTime endDate, Integer page);

    Page<Plant> findAllByHasFlowerTrue(Integer page);

    Page<PlantProjection> findByType(PlantType type, Integer page);

    Page<Plant> advancedSearch(PlantAdvanceSearch plant, Integer page);

    //    jpql
    List<Plant> findAllWithFlower();

    Page<Plant> findByTypeAndDate(PlantType type, ZonedDateTime fromDate,  Integer page);


}
