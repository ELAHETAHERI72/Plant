package org.Appllication.domain;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = UploadFile.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UploadFile extends BaseUpload implements Serializable {

    public static final String TABLE_NAME = "upload-file";

    public static final String CONTENT = "content";


    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    //@Lob stands for Large Object. It's a JPA annotation used to map large data types in Java to large object types in the database. like BLOB
    @Lob
    @Column(columnDefinition = "BYTEA",name = CONTENT)
    private byte[] content;


}
