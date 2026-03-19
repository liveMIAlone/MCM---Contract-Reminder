package com.EacStudentPort.springboot.EAC1.repository;

import org.aspectj.apache.bcel.classfile.Module.Uses;
import org.springframework.data.repository.CrudRepository;

import com.EacStudentPort.springboot.EAC1.model.User;

// Import Department if needed

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
    // You can add more query methods here if needed



void save(Uses user);
}
