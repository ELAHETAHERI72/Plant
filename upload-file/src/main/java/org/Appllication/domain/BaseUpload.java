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
