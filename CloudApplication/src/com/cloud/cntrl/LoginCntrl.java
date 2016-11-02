package com.cloud.cntrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.cloud.dao.UserDAO;
import com.cloud.domain.Credentials;

public class LoginCntrl implements Controller{
	private UserDAO userDao;
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
		String userName = request.getParameter("txtUserName");
		String password= request.getParameter("txtPassword");
		Map<String, Object> model = new HashMap<String, Object>();
		ArrayList credentials = (ArrayList) getUserDao().findUser(userName, password);
		if(credentials.size()>0)
			model.put("msg", "Login Successful");
		else
			model.put("msg", "Invalid User");
		return new ModelAndView("resultPage", "msg", model); 
	}
	
	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
}
