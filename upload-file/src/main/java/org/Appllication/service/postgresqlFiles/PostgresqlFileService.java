package org.Appllication.service.postgresqlFiles;

import org.Appllication.domain.UploadFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface PostgresqlFileService {

    UploadFile uploadFile(MultipartFile file);

}
