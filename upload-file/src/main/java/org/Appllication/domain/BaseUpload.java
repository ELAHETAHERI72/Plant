package org.Appllication.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.ZonedDateTime;

@Setter
@Getter
@AllArgsConstructor
@ToString
//is a JPA (Java Persistence API) annotation that allows you
//        to define common fields and mappings in a parent class,
//        which can be inherited by entity classes,
//        without the parent class itself being an entity.
@MappedSuperclass
public abstract class BaseUpload {

    private String fileName;
    private String fileType;
    private Long fileSize;
    private ZonedDateTime uploadTime;

    public BaseUpload() {
        this.uploadTime = ZonedDateTime.now();
    }
}
