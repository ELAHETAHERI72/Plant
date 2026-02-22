package org.Appllication.util;

import org.Appllication.dto.PlantRequest;
import org.Appllication.enumeration.PlantType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import java.util.concurrent.ThreadLocalRandom;

public class PlantGenerator {

    public static List<PlantRequest> generateRandomPlant(int n) {
        List<PlantRequest> listArr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            PlantRequest plant = new PlantRequest();
            plant.setName(createRandomString(5));
            plant.setColor(createRandomString(5));
            plant.setDescription(createRandomString(10));
            plant.setAge(createRandomNumber(2));
            plant.setSize(createRandomNumber(5));
            plant.setWateringPeriod(createRandomString(6));
            plant.setType(createRandomType());
            plant.setHasFlower(true);
            listArr.add(plant);
        }
        return listArr;
    }

   public static PlantType createRandomType() {
       List<String> types = Arrays.asList("ONE", "TWO", "TREE", "FOUR", "FIVE", "SIX", "SEVEN");
       String s = types.get(ThreadLocalRandom.current().nextInt(types.size()));
       return PlantType.valueOf(s);
   }

    public static String createRandomString(int count) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder character = new StringBuilder();
        Random random = new Random();
        while (character.length() < count) {
            int index = (int) (random.nextFloat() * chars.length());
            character.append(chars.charAt(index));
        }
        String charStr = character.toString();
        return charStr;

    }

    public static int createRandomNumber(int count) {
        Random random = new Random();
        int n = random.nextInt(count);

        n += 1;

        return n;

    }

}
