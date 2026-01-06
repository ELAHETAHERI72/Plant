package com.plant.plant.domain;

import com.plant.plant.enumeration.PlantType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.time.ZonedDateTime;

import static com.plant.plant.domain.Plant.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Plant implements Serializable {
    public static final String TABLE_NAME = "plant";

    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String HAS_FLOWER = "has_flower";
    public static final String WATERING_PERIOD = "watering_period";
    public static final String DESCRIPTION = "description";
    public static final String CREATE_DATE = "create_date";
    public static final String UPDATE_DATE = "update_date";
    public static final String COLOR = "color";
    public static final String AGE = "age";
    public static final String SIZE = "size";
    public static final String TYPE_ID = "type_id";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = NAME)
    private String name;
    @Column(name = TYPE)
    private PlantType type;
    @Column(name = HAS_FLOWER)
    private Boolean hasFlower;
    @Column(name = WATERING_PERIOD)
    private String wateringPeriod;
    @Column(name = DESCRIPTION)
    private String description;
    @Column(name = UPDATE_DATE,
            nullable = false,
            insertable = false,   // Hibernate won't include in INSERT
            updatable = true,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private ZonedDateTime updateDate;
    @Column(name = CREATE_DATE,
            nullable = false,
            insertable = false,   // Hibernate won't include in INSERT
            updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private ZonedDateTime createDate;
    @Column(name = COLOR)
    private String color;
    @Column(name = AGE)
    private Integer age;
    @Column(name = SIZE)
    private Integer size;

    @ManyToOne
    @JoinColumn(name = TYPE_ID)
    private PlantCategory typeId;

}
