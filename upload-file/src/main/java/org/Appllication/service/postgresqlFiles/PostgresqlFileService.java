package org.Appllication.service.postgresqlFiles;

import org.Appllication.domain.UploadFile;
import org.springframework.web.multipart.MultipartFile;

public interface PostgresqlFileService {

    UploadFile storeFile(MultipartFile file);

}
