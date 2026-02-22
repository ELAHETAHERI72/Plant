package org.Appllication.repository;

import org.Appllication.domain.Plant;
import org.Appllication.dto.projection.PlantProjection;
import org.Appllication.enumeration.PlantType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long>, JpaSpecificationExecutor<Plant> {
    List<Plant> findByAge(Integer age);

    List<Plant> findByAgeBetween(Integer startAge, Integer endAge);

    Page<Plant> findAllByCreateDateBetweenOrderByCreateDateDesc(ZonedDateTime startDate, ZonedDateTime endDate, Pageable page);

    Page<Plant> findAllByHasFlowerTrue(Pageable page);

    Page<PlantProjection> findByType(PlantType type, Pageable page);


    //    jpql
    @Query("SELECT p FROM Plant p WHERE p.hasFlower = true")
    List<Plant> findAllWithFlower();

    @Query("SELECT p FROM Plant p WHERE p.type = :type AND p.createDate >= :fromDate ORDER BY p.createDate DESC")
    Page<Plant> findByTypeAndDate(
            @Param("type") PlantType type,
            @Param("fromDate") ZonedDateTime fromDate,
            Pageable page);

    @Query("SELECT p FROM Plant p WHERE p.age between :startAge and :endAge")
    Page<Plant> findPlantsBasedOnRangeAge(@Param("startAge") Integer startAge,
                                          @Param("endAge") Integer endAge,
                                          Pageable page);

    @Query("SELECT p FROM Plant p WHERE p.name LIKE %:keyword%")
    List<Plant> searchByName(@Param("keyword") String keyword);


    // native query
    @Query(value = """
            SELECT * FROM Plant where color
            """,
            nativeQuery = true)
    List<Plant> findAllPlantNative(Pageable page);

    @Query(value = """
            SELECT * FROM plant WHERE has_flower = true
            """,
            nativeQuery = true)
    List<Plant> findAllWithFlowerNative();


}
