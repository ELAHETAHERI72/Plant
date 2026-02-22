package org.Appllication.mapper;

import org.Appllication.domain.UploadFile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.multipart.MultipartFile;

@Mapper
public interface PostgresUploadMapper {

   @Mapping(source = "fileName",target = "model.getOriginalFilename()")
   @Mapping(source = "fileType",target = "model.getContentType()")
   @Mapping(source = "fileSize",target = "model.getSize()")
   @Mapping(source = "content",target = "model.getBytes()")
    UploadFile toDomain(MultipartFile model);

}
