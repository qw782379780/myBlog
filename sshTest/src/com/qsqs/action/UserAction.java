package com.qsqs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.qsqs.model.User;
import com.qsqs.service.UserService;
import com.qsqs.service.Impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user = new User();
	
	public User getModel() {
		return user;
	}
	
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

    //登录
	public String login() {
		User u = userService.login(user);
		if(u!=null){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			return SUCCESS;
		}
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set("msg", "用户名或密码输入错误");
		return ERROR;
	}
	//注册
	public String addUser() {
		if(!user.getUsername().equals("")&&!user.getUserpassword().equals("")&&!user.getEmail().equals("")){
			if(userService.checkUsername(user)!=null){
				ValueStack valueStack = ActionContext.getContext().getValueStack();
				valueStack.set("msg", "用户名被占用");
				return ERROR;
			}
		    userService.addUser(user);
			return SUCCESS;
		}else{
			ValueStack valueStack = ActionContext.getContext().getValueStack();
			valueStack.set("msg", "请输入正确的信息");
			return ERROR;
		}
	}
	
	public String loginOut(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "success";
	}
	//检查用户名是否被占用
	public String checkUsername(){
		User u = userService.checkUsername(user);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter writer = response.getWriter();
			if(u!=null){
				//如果查询到的user不为空，说明用户名已经存在，不能注册
				writer.print("Unavailable");
			}else{
				//可以注册
				writer.print("Available");
			}
		} catch (IOException e) {
		}
		return NONE;
	}
	
	//显示userInfo
	public String userInfo(){
		User u = userService.checkUsername(user);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter writer = response.getWriter();
            String userInfo = "{username:'"+u.getUsername()+"',email:'"+u.getEmail()+"'}";
			writer.print(userInfo);
		} catch (IOException e) {
		}
		return NONE;
	}
}