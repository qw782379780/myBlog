package com.qsqs.model;

public class User{  

	// Fields  
	private Integer userId;  
	private String email; 
    private String username;  
    private String userpassword;
    
   // Constructors  
    public User(){
    }
    
	public User(Integer userId, String email, String username, String userpassword) {
		super();
		this.userId = userId;
		this.email = email;
		this.username = username;
		this.userpassword = userpassword;
	}  
	  
    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
    
  
  
   

}  
