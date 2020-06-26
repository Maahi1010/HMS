package com.service;

import com.bean.UserBean;
import com.dao.UserDao;

public class UserService {
	
	public boolean validateLogin(String username,String password) {
		UserDao userDAO = new UserDao();
		boolean isValid = userDAO.validateLogin(username,password);
		return isValid;
	}
}
		