package com.tb.services;

import java.sql.SQLException;

import com.tb.beans.User;
import com.tb.datalayer.UserDataLayer;

public class UserServicesImpl implements UserServices
{
	private UserDataLayer userDataLayer;
	
	public UserServicesImpl() throws ClassNotFoundException, SQLException 
	{
		userDataLayer = new UserDataLayer();
	}
	
	public int saveUser(User user) throws SQLException 
	{	 
		return userDataLayer.saveUser(user);
	}

	public int login(User user) 
	{
		return 0;
	}

	public int loginByName(User user) 
	{
		return 0;
	}

	public int loginById(User user)
	{
		return 0;
	}

}
