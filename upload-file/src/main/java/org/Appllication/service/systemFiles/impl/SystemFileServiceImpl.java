package org.Appllication.service.systemFiles.impl;

import lombok.RequiredArgsConstructor;
import org.Appllication.domain.SystemFile;
import org.Appllication.mapper.SystemFileUploadMapper;
import org.Appllication.repository.SystemFileRepository;
import org.Appllication.service.systemFiles.SystemFileService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SystemFileServiceImpl implements SystemFileService {
    @Value("${file.download.path}")
    private String uploadDir;

    private final SystemFileRepository repo;
    private SystemFileUploadMapper mapper;

    @Override
    @Transactional
    public SystemFile storeFile(MultipartFile file) throws IOException {

        // Create upload directory if it doesn't exist
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Generate unique filename
        String originalFileName = file.getOriginalFilename();
        String extension = FilenameUtils.getExtension(originalFileName);
        String fileNameWithoutExt = FilenameUtils.removeExtension(originalFileName);
        String uniqueFileName = fileNameWithoutExt + "_" + UUID.randomUUID() + "." + extension;

        // Store file
        Path filePath = uploadPath.resolve(uniqueFileName);
        Files.copy(file.getInputStream(), filePath);

        // Save metadata
        SystemFile systemFile = mapper.toDomain(file, filePath, originalFileName);

        return systemFile;
    }
}
