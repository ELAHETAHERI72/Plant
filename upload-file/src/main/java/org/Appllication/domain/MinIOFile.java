package org.Appllication.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = MinIOFile.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MinIOFile extends BaseUpload implements Serializable {

    public static final String TABLE_NAME = "minio_files";

    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    private String objectName;
    private String bucketName;
    private String etag;



}
