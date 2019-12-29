package com.tb.services;

import java.sql.SQLException;

import com.tb.beans.User;

public interface UserServices
{
	int saveUser(User user) throws SQLException;

	int login(User user);

	int loginByName(User user);

	int loginById(User user);
}
