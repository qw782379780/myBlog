package com.qsqs.dao;

import com.qsqs.model.User;

public interface UserDao {

	public User login(User user);
	
	public void addUser(User user);

	public User checkUsername(User user);

}
