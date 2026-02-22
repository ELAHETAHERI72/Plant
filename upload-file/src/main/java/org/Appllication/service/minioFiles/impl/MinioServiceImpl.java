package org.Appllication.service.minioFiles.impl;

import org.Appllication.service.minioFiles.MinioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MinioServiceImpl implements MinioService {
}
