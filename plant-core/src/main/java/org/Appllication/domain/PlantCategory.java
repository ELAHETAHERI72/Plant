package org.Appllication.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.apachecommons.CommonsLog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = PlantCategory.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlantCategory implements Serializable {
    public static final String TABLE_NAME = "plantCategory";

    public static final String TITLE = "title";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = TITLE)
    private String title;

    @OneToMany(mappedBy = "type",orphanRemoval = true)
    private List<Plant> plants = new ArrayList<>();


    public void addPlant(Plant plant) {
        this.plants.add(plant);
        plant.setType(this);
    }
}
