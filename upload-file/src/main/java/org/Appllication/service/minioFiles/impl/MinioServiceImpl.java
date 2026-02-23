package org.Appllication.service.minioFiles.impl;

import io.minio.*;
import lombok.RequiredArgsConstructor;
import org.Appllication.domain.MinIOFile;
import org.Appllication.mapper.MinioUploadMapper;
import org.Appllication.repository.MinIOFileRepository;
import org.Appllication.service.minioFiles.MinioService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MinioServiceImpl implements MinioService {

    @Value("${minio.buckets}")
    private String bucketName;
    private MinioClient minioClient;
    private final MinIOFileRepository repo;
    private MinioUploadMapper mapper;

    @Override
    @Transactional
    public MinIOFile storeFile(MultipartFile file) throws Exception {
        createBucketIfNotExists();

        // Generate unique object name
        String objectName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        // Upload to MinIO
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .stream(file.getInputStream(), file.getSize(), -1)
                .contentType(file.getContentType())
                .build();

        ObjectWriteResponse response = minioClient.putObject(putObjectArgs);

        MinIOFile minIOFile = mapper.toDomain(file, response, bucketName);

        return repo.save(minIOFile);
    }


    private void createBucketIfNotExists() throws Exception {
        boolean found = minioClient.bucketExists(
                BucketExistsArgs.builder().bucket(bucketName).build()
        );

        if (!found) {
            minioClient.makeBucket(
                    MakeBucketArgs.builder().bucket(bucketName).build()
            );
        }
    }
}
