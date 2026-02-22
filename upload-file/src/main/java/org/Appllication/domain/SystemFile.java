package org.Appllication.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = SystemFile.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SystemFile extends BaseUpload implements Serializable {

    public static final String TABLE_NAME = "system_files";

    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    private String filePath;
}
