package org.Appllication.service.minioFiles;

import org.Appllication.domain.MinIOFile;
import org.springframework.web.multipart.MultipartFile;

public interface MinioService {

    public MinIOFile storeFile(MultipartFile file) throws Exception;
}
