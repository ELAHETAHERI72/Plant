package com.plant.plant;

import com.plant.plant.service.PlantService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PlantApplication {


    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(PlantApplication.class, args);
        PlantService service = run.getBean(PlantService.class);


//        List<PlantRequest> plant = PlanGenerator.generateRandomPlant(20);
//
//        for (int i = 0; i < plant.size(); i++) {
//
//            service.create(plant.get(i));
//        }

    }

}
