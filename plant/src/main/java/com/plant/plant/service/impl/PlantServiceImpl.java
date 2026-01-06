package com.plant.plant.service.impl;

import com.plant.plant.domain.Plant;
import com.plant.plant.dto.PlantAdvanceSearch;
import com.plant.plant.dto.PlantRequest;
import com.plant.plant.dto.PlantResponse;
import com.plant.plant.dto.projection.PlantProjection;
import com.plant.plant.enumeration.PlantType;
import com.plant.plant.repository.PlantRepository;
import com.plant.plant.service.PlantService;
import com.plant.plant.service.PlantSpecification;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlantServiceImpl implements PlantService {

    private final PlantRepository baseRepository;
    private ModelMapper mapper;

    @Override
    @Transactional
    public PlantResponse create(PlantRequest model) {
        Plant plant = new Plant();
        plant.setName(model.getName());
        plant.setDescription(model.getDescription());
        plant.setAge(model.getAge());
        plant.setColor(model.getColor());
        plant.setHasFlower(model.getHasFlower());
        plant.setType(model.getType());
        plant.setSize(model.getSize());
        plant.setWateringPeriod(model.getWateringPeriod());

        Plant saveResponse = baseRepository.save(plant);

        PlantResponse response = getPlantResponse(saveResponse);

        return response;
    }

    private static PlantResponse getPlantResponse(Plant saveResponse) {
        PlantResponse response = new PlantResponse();
        response.setId(saveResponse.getId());
        response.setCreateDate(saveResponse.getCreateDate());
        response.setUpdateDate(saveResponse.getUpdateDate());
        response.setName(saveResponse.getName());
        response.setDescription(saveResponse.getDescription());
        response.setAge(saveResponse.getAge());
        response.setColor(saveResponse.getColor());
        response.setHasFlower(saveResponse.getHasFlower());
        response.setType(saveResponse.getType());
        response.setSize(saveResponse.getSize());
        response.setWateringPeriod(saveResponse.getWateringPeriod());
        return response;
    }

    @Override
    @Transactional
    public void update(PlantRequest model, Long id) {
        Plant plant = baseRepository.getReferenceById(id);
        plant.setName(model.getName());
        plant.setColor(model.getColor());
        plant.setDescription(model.getDescription());
        plant.setType(model.getType());
        plant.setAge(model.getAge());
        plant.setSize(model.getSize());
        plant.setHasFlower(model.getHasFlower());
        plant.setWateringPeriod(model.getWateringPeriod());
        baseRepository.save(plant);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        baseRepository.deleteById(id);

    }

    @Override
    public List<Plant> getAll() {
        return baseRepository.findAll();
    }


    @Override
    public List<Plant> getByAge(Integer age) {
        List<Plant> plants = baseRepository.findByAge(age);
//                .orElseThrow(
//                        () -> new RuntimeException("plant not found")
//                );

        return plants;
    }

    @Override
    public List<Plant> findByAgeBetween(Integer startAge, Integer endAge) {
        List<Plant> plants = baseRepository.findByAgeBetween(startAge, endAge);
        return plants;
    }


    @Override
    public Page<Plant> getAllByCreateDateRangeOrderByCreateDateDesc(ZonedDateTime startDate,
                                                                    ZonedDateTime endDate,
                                                                    Integer page) {
        Page<Plant> plants = baseRepository.findAllByCreateDateBetweenOrderByCreateDateDesc(startDate, endDate,
                PageRequest.of(page, 1000, Sort.by("createDate")));
        return plants;
    }

    @Override
    public Page<Plant> findAllByHasFlowerTrue(Integer page) {
        Page<Plant> plants = baseRepository.findAllByHasFlowerTrue(PageRequest.of(page,
                4, Sort.by(Sort.Direction.DESC, "createDate")));
        return plants;
    }

    @Override
    public Page<PlantProjection> findByType(PlantType type, Integer page) {
        Page<PlantProjection> plants = baseRepository.findByType(type, PageRequest.of(page, 4,
                Sort.by(Sort.Direction.DESC, "createDate")));
        return plants;
    }

    @Override
    public Page<Plant> advancedSearch(PlantAdvanceSearch plant, Integer page) {

/////////// second approach
//        baseRepository.findAll((root, query, plantBuilder) -> {
//
//        })

        int pageIndex = Math.max(page - 1, 0);

        Specification<Plant> spec = (root, query, cb) -> cb.conjunction();

        if (plant.getName() != null && !plant.getName().isEmpty()) {
            spec = PlantSpecification.withNameContaining(plant.getName());
        }
        if (plant.getType() != null) {
            spec = (spec == null)
                    ? PlantSpecification.withTypeEqual(plant.getType())
                    : spec.and(PlantSpecification.withTypeEqual(plant.getType()));
        }
        if (plant.getSize() != null) {
            spec = (spec == null)
                    ? PlantSpecification.withSizeEqual(plant.getSize())
                    : spec.and(PlantSpecification.withSizeEqual(plant.getSize()));
        }
        if (plant.getAge() != null) {
            spec = (spec == null)
                    ? PlantSpecification.withAgeEqual(plant.getAge())
                    : spec.and(PlantSpecification.withAgeEqual(plant.getAge()));
        }
        if (plant.getColor() != null) {
            spec = (spec == null)
                    ? PlantSpecification.withColorEqual(plant.getColor())
                    : spec.and(PlantSpecification.withColorEqual(plant.getColor()));
        }
        if (plant.getHasFlower() != null) {
            spec = (spec == null)
                    ? PlantSpecification.hasFlower(plant.getHasFlower())
                    : spec.and(PlantSpecification.hasFlower(plant.getHasFlower()));
        }
        if (plant.getFromDate() != null || plant.getToDate() != null) {
            Specification<Plant> dateSpec = PlantSpecification.createdBetween(plant.getFromDate(), plant.getToDate());
            spec = (spec == null) ? dateSpec : spec.and(dateSpec);
        }

        return baseRepository.findAll(
                spec,
                PageRequest.of(pageIndex, 4, Sort.by(Sort.Direction.DESC, "createDate"))
        );
    }

    @Override
    public List<Plant> findAllWithFlower() {
        List<Plant> plants = baseRepository.findAllWithFlower();
        return plants;
    }

    @Override
    public Page<Plant> findByTypeAndDate(PlantType type, ZonedDateTime fromDate, Integer page) {

        Page<Plant> plants = baseRepository.findByTypeAndDate(type, fromDate, PageRequest.of(page, 4,
                Sort.by(Sort.Direction.DESC, "createDate")));

        return plants;
    }


}
