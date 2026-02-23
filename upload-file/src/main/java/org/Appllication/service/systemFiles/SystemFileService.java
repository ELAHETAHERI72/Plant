package org.Appllication.service.systemFiles;

import org.Appllication.domain.SystemFile;
import org.Appllication.domain.UploadFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface SystemFileService {
   public SystemFile storeFile(MultipartFile file) throws IOException;
}
