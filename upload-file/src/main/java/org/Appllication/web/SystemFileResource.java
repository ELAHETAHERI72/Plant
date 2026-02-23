package org.Appllication.web;

import lombok.RequiredArgsConstructor;
import org.Appllication.domain.SystemFile;
import org.Appllication.service.systemFiles.SystemFileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/system/files")
@RequiredArgsConstructor
public class SystemFileResource {

    private SystemFileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<SystemFile> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            SystemFile storedFile = fileService.storeFile(file);
            return ResponseEntity.ok(storedFile);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
