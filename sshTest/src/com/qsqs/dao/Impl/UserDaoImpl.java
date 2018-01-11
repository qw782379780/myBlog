package com.qsqs.dao.Impl;

import java.util.List;  

  
import com.qsqs.dao.UserDao;  
import com.qsqs.model.User;  
  
public class UserDaoImpl extends BaseDaoImpl implements UserDao {  
	
    @SuppressWarnings("unchecked")  
    public User login(User user) {  
        String hql = "from User where username = ? and userpassword = ?";  
        List<User> list = this.getSessionFactory().openSession().createQuery(  
                hql).setString(0,user.getUsername()).setString(1,user.getUserpassword()).list();  
        if(list!=null && list.size()>0){
        	return list.get(0);
        }
		return null;
    }  
  
    public void addUser(User user) {
        this.getSessionFactory().openSession().save(user);
    }

	public User checkUsername(User user) {
		String hql = "from User where username = ?";  
        List<User> list = this.getSessionFactory().openSession().createQuery(  
                hql).setString(0,user.getUsername()).list();
        if(list!=null&&list.size()>0){
        	return list.get(0);
        }
		return null;
	}  

}  
