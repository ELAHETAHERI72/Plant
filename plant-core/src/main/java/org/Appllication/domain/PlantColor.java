package org.Appllication.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = PlantColor.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlantColor {
    public static final String TABLE_NAME = "plantColor";

    public static final String TITLE = "title";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = TITLE)
    private String title;


}
