package org.Appllication.service.postgresqlFiles.impl;

import lombok.RequiredArgsConstructor;
import org.Appllication.domain.UploadFile;
import org.Appllication.mapper.PostgresUploadMapper;
import org.Appllication.repository.UploadFileRepository;
import org.Appllication.service.postgresqlFiles.PostgresqlFileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class PostgresqlFileServiceImpl implements PostgresqlFileService {

    private final UploadFileRepository repo;

    private PostgresUploadMapper mapper;

    @Override
    @Transactional
    public UploadFile storeFile(MultipartFile file) {
        System.out.println(file.getSize());
        UploadFile fileEntity = mapper.toDomain(file);
        return repo.save(fileEntity);
    }
}
