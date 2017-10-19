package com.EM2.WebApplication.service;

import com.EM2.WebApplication.model.User;

public interface UserService {

	public User findUserByEmail(String email);
	public void saveUser(User user);
}
