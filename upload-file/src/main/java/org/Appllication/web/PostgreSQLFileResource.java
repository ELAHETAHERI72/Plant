package org.Appllication.web;

import lombok.RequiredArgsConstructor;
import org.Appllication.domain.UploadFile;
import org.Appllication.service.postgresqlFiles.PostgresqlFileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/postgres/files")
@RequiredArgsConstructor
public class PostgreSQLFileResource {

    private PostgresqlFileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<UploadFile> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            UploadFile storedFile = fileService.storeFile(file);
            return ResponseEntity.ok(storedFile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
