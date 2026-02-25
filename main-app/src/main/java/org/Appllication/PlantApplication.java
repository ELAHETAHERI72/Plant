package org.Appllication;

import org.Appllication.dto.PlantRequest;
import org.Appllication.service.PlantService;
import org.Appllication.util.PlantGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@SpringBootApplication
public class PlantApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PlantApplication.class, args);
        PlantService service = run.getBean(PlantService.class);

        List<PlantRequest> plants = PlantGenerator.generateRandomPlant(10);
        for (int i = 0; i < plants.size(); i++) {
            service.create(plants.get(i));
        }
    }
}