package com.EacStudentPort.springboot.EAC1.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.EacStudentPort.springboot.EAC1.model.Upload;

@Repository
public interface UploadRepository extends JpaRepository<Upload, Long> {
    List<Upload> findByProjectType(String projectType);
}
