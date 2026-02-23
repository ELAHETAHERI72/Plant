package org.Appllication.web;

import lombok.RequiredArgsConstructor;
import org.Appllication.domain.MinIOFile;
import org.Appllication.service.minioFiles.MinioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/minio/files")
@RequiredArgsConstructor
public class MinioResource {
    private MinioService service;

    @PostMapping("/upload")
    public ResponseEntity<MinIOFile> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            MinIOFile storedFile = service.storeFile(file);
            return ResponseEntity.ok(storedFile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
