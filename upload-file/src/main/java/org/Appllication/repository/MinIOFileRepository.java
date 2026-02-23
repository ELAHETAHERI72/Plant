package org.Appllication.repository;

import org.Appllication.domain.MinIOFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MinIOFileRepository extends JpaRepository<MinIOFile,String> {
}
