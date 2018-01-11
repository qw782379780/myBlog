package com.qsqs.service.Impl;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Transactional;

import com.qsqs.dao.UserDao;
import com.qsqs.model.User;
import com.qsqs.service.UserService;

@Transactional
public class UserServiceImpl implements UserService {


	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
    //登录
	public User login(User user) {
		HttpServletRequest request = ServletActionContext.getRequest();
		String remoteHost = request.getRemoteHost();
		String remoteAddr = request.getRemoteAddr();
		System.out.println(remoteHost);
		System.out.println(remoteAddr);
		System.out.println("用户名："+user.getUsername()+"    "+"密码："+user.getUserpassword());
//		Date now = new Date();
		Calendar rightNow = Calendar.getInstance();
	      DateFormat d1 = DateFormat.getDateTimeInstance();
	      System.out.println(d1.format(rightNow.getTime()));
		// TODO Auto-generated method stub
		return userDao.login(user);
	}
	
	//注册
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}
	
	//检查用户名是否被占用
	public User checkUsername(User user){
		return userDao.checkUsername(user);
	}
}
