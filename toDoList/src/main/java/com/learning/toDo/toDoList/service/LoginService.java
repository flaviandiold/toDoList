package com.learning.toDo.toDoList.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learning.toDo.toDoList.model.User;

@Service
public class LoginService {
	private String username;
	private String password;
	
	LoginRepository loginRepository;
	
	public LoginService(LoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
	}

	public boolean isPresent(String username) {
		Optional<User> user = loginRepository.findById(username);
		if(user.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public boolean hasPassword(String username, String password) {
		String pass = loginRepository.findById(username).get().getPassword();
		if(pass.equals(password)) {
			return true;
		}
		return false;
	}
	
	public String getName(String username) {
		return loginRepository.findById(username).get().getName();
	}

	public void add(User user) {
		loginRepository.save(user);
	}
}
