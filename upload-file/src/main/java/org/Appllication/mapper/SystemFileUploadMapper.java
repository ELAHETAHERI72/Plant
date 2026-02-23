package org.Appllication.mapper;

import io.minio.ObjectWriteResponse;
import org.Appllication.domain.MinIOFile;
import org.Appllication.domain.SystemFile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@Mapper
public interface SystemFileUploadMapper {

    @Mapping(source = "fileName", target = "originalFileName")
    @Mapping(source = "fileType", target = "model.getContentType()")
    @Mapping(source = "fileSize", target = "model.getSize()")
    @Mapping(source = "filePath", target = "filePath")
    SystemFile toDomain(MultipartFile model, Path filePath, String originalFileName);
}
