package com.plant.plant.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.apachecommons.CommonsLog;

import java.io.Serializable;

import static com.plant.plant.domain.Plant.TABLE_NAME;

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


}
