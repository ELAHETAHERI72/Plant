package org.Appllication.mapper;

import io.minio.ObjectWriteResponse;
import org.Appllication.domain.MinIOFile;
import org.Appllication.domain.UploadFile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.multipart.MultipartFile;

@Mapper
public interface MinioUploadMapper {
    @Mapping(source = "fileName", target = "model.getOriginalFilename()")
    @Mapping(source = "fileType", target = "model.getContentType()")
    @Mapping(source = "fileSize", target = "model.getSize()")
    @Mapping(source = "objectName", target = "model.objectName()")
    @Mapping(source = "bucketName", target = "bucketName")
    @Mapping(source = "etag", target = "res.etag()")
    MinIOFile toDomain(MultipartFile model, ObjectWriteResponse res, String bucketName);
}
