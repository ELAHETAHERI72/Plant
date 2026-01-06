package com.plant.plant.service;

import com.plant.plant.domain.Plant;
import com.plant.plant.enumeration.PlantType;
import org.springframework.data.jpa.domain.Specification;

import java.time.ZonedDateTime;

public class PlantSpecification {

    public static Specification<Plant> withNameContaining(String name) {
        return (root, query, cb) -> {
            if (name == null || name.isEmpty()) return cb.conjunction();
            return cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
        };
    }

    public static Specification<Plant> withDescriptionContaining(String description) {
        return (root, query, cb) -> {
            if (description == null || description.isEmpty()) return cb.conjunction();
            return cb.like(cb.lower(root.get("description")), "%" + description.toLowerCase() + "%");
        };
    }

    public static Specification<Plant> createdBetween(ZonedDateTime from, ZonedDateTime to) {
        return (root, query, cb) -> {
            if (from == null && to == null) return cb.conjunction();
            if (from != null && to != null) {
                return cb.between(root.get("createDate"), from, to);
            } else if (from != null) {
                return cb.greaterThanOrEqualTo(root.get("createDate"), from);
            } else {
                return cb.lessThanOrEqualTo(root.get("createDate"), to);
            }
        };
    }

    public static Specification<Plant> withWateringPeriodContaining(String wateringPeriod) {
        return (root, query, cb) -> {
            if (wateringPeriod == null || wateringPeriod.isEmpty()) return cb.conjunction();
            return cb.like(cb.lower(root.get("wateringPeriod")), "%" + wateringPeriod.toLowerCase() + "%");
        };
    }


    public static Specification<Plant> withTypeEqual(PlantType type) {
        return (root, query, cb) -> {
            if (type == null) return cb.conjunction();
            return cb.equal(root.get("type"), type);
        };
    }


    public static Specification<Plant> withColorEqual(String color) {
        return (root, query, cb) -> {
            if (color == null) return cb.conjunction();
            return cb.equal(root.get("color"), color);
        };
    }


    public static Specification<Plant> withAgeEqual(Integer age) {
        return (root, query, cb) -> {
            if (age == null) return cb.conjunction();
            return cb.equal(root.get("age"), age);
        };
    }


    public static Specification<Plant> withSizeEqual(Integer size) {
        return (root, query, cb) -> {
            if (size == null) return cb.conjunction();
            return cb.equal(root.get("size"), size);
        };
    }

    public static Specification<Plant> hasFlower(Boolean hasFlower) {
        return (root, query, cb) -> {
            if (hasFlower == null) return cb.conjunction();
            return cb.equal(root.get("hasFlower"), hasFlower);
        };
    }


}
