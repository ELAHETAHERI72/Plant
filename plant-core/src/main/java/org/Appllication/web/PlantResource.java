package org.Appllication.web;


import lombok.RequiredArgsConstructor;
import org.Appllication.domain.Plant;
import org.Appllication.dto.PlantAdvanceSearch;
import org.Appllication.dto.PlantRequest;
import org.Appllication.dto.PlantResponse;
import org.Appllication.enumeration.PlantType;
import org.Appllication.service.PlantService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RequestMapping("/plant")
@RestController
@RequiredArgsConstructor
public class PlantResource {
    private final PlantService baseService;

    @PostMapping("/add")
    public ResponseEntity<PlantResponse> create(@RequestBody PlantRequest request) {
        PlantResponse response = baseService.create(request);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody PlantRequest request, @PathVariable Long id) {
        baseService.update(request, id);
        return ResponseEntity.ok("data was updated");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Plant>> getAll() {
        List<Plant> response = baseService.getAll();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        baseService.delete(id);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/age")
    public ResponseEntity<List<Plant>> getDataByAge(@RequestParam("age") Integer age) {
        List<Plant> response = baseService.getByAge(age);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/searchByDate")
    public ResponseEntity<Page<Plant>> getAllByCreateDateRangeOrderByCreateDateDesc(
            @RequestParam("startDate") ZonedDateTime startDate,
            @RequestParam("endDate") ZonedDateTime endDate,
            @RequestParam("page") Integer page) {
        Page<Plant> response = baseService.getAllByCreateDateRangeOrderByCreateDateDesc(startDate, endDate, page);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/ageBetween")
    public ResponseEntity<List<Plant>> findByAgeBetween(
            @RequestParam("startAge") Integer startAge,
            @RequestParam("endAge") Integer endAge) {
        List<Plant> response = baseService.findByAgeBetween(startAge, endAge);

        return ResponseEntity.ok(response);
    }


    @GetMapping("/hasFlower")
    public ResponseEntity<Page<Plant>> findPlatByHasFlower(@RequestParam(defaultValue = "0") Integer page) {
        Page<Plant> response = baseService.findAllByHasFlowerTrue(page);

        return ResponseEntity.ok(response);
    }


    //    jpql
    @GetMapping("/allFlower")
    public ResponseEntity<List<Plant>> findAllWithFlower() {
        List<Plant> result = baseService.findAllWithFlower();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/typeAndDate")
    public ResponseEntity<Page<Plant>> findByTypeAndDate(
            @RequestParam("type") PlantType type,
            @RequestParam("fromDate")
            ZonedDateTime fromDate,
            @RequestParam(required = false, defaultValue = "0") Integer page) {
        Page<Plant> result = baseService.findByTypeAndDate(type, fromDate, page);
        return ResponseEntity.ok(result);
    }


    @GetMapping("/betweenAge")
    public ResponseEntity<Page<Plant>> findPlantsBasedOnRangeAge(
            @RequestParam("startAge") Integer startAge,
            @RequestParam("endAge") Integer endAge,
            @RequestParam(required = false, defaultValue = "0") Integer page) {
        Page<Plant> result = baseService.findPlantsBasedOnRangeAge(startAge, endAge, page);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Plant>> searchByName(@RequestParam("keyword") String keyword) {
        List<Plant> result = baseService.searchByName(keyword);
        return ResponseEntity.ok(result);
    }


    //    Advance search
    @PostMapping("/search")
    public ResponseEntity<Page<Plant>> advancedSearch(
            @RequestBody PlantAdvanceSearch model,
            @RequestParam(required = false, defaultValue = "0") Integer page) {
         // @ModelAttribute PlantAdvanceSearch model, instead of @RequestBody PlantAdvanceSearch
        // if data model send as queryParam
        Page<Plant> result = baseService.advancedSearch(model, page);
        return ResponseEntity.ok(result);
    }
}
