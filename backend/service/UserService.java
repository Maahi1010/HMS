package com.service;

import com.bean.UserBean;
import com.dao.UserDao;

public class UserService {
	
	public boolean validateLogin(LoginBean userBn ) {
		UserDao userDAO = new UserDao();
		boolean isValid = userDAO.validateLogin(userBn);
		
		return isValid;
	}
}
		
