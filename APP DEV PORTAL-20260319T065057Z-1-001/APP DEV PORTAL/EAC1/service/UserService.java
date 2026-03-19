package com.EacStudentPort.springboot.EAC1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.EacStudentPort.springboot.EAC1.model.User;
import com.EacStudentPort.springboot.EAC1.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
 	
 	public void save(User user) {
 		userRepository.save(user);
 	}
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	public void saveProject(String title, String description, String code, String projectType) {
		// TODO Auto-generated method stub
		
	}

}