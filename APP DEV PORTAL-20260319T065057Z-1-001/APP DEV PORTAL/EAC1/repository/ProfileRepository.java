package com.EacStudentPort.springboot.EAC1.repository;

import com.EacStudentPort.springboot.EAC1.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
