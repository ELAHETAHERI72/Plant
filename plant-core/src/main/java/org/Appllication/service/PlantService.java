package org.Appllication.service;

import lombok.Setter;
import org.Appllication.domain.Plant;
import org.Appllication.dto.PlantAdvanceSearch;
import org.Appllication.dto.PlantRequest;
import org.Appllication.dto.PlantResponse;
import org.Appllication.dto.projection.PlantProjection;
import org.Appllication.enumeration.PlantType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

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

    //    jpql
    List<Plant> findAllWithFlower();

    Page<Plant> findPlantsBasedOnRangeAge(Integer startAge, Integer endAge, Integer page);

    Page<Plant> findByTypeAndDate(PlantType type, ZonedDateTime fromDate, Integer page);

    List<Plant> searchByName(String keyword);


    //    native
//    List<Plant> findAllPlant(Integer page);


    //Advance search
    Page<Plant> advancedSearch(PlantAdvanceSearch plant, Integer page);

}
