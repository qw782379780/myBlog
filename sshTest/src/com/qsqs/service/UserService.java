package com.qsqs.service;

import com.qsqs.model.User;

public interface UserService {  
	
	 public User login(User user);  
	 
     public void addUser(User user);
     
     public User checkUsername(User user);
		
}  
