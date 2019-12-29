package com.tb.datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.tb.beans.User;

public class UserDataLayer 
{
	Connection connection;
	
	public UserDataLayer() throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/teststudent", "root", "root");
	}
	
	//public boolean saveUser(User user) throws SQLException
	//{
		//String query = "INSERT INTO teststudent.user(name, age, contact,email, password) VALUES('"+user.getName()+"', "+user.getAge()+", '"+user.getContact()+"', '"+user.getPassword()+"', '"+user.getEmail()+"');";
		//Statement statement = null;
		//boolean status = false;
		//if (user!= null)
		//{
			//int id = user.getId();
			//statement = connection.createStatement();
			//statement.execute(query);
		//}
		//return status;
	//}
	
	public int saveUser(User user) throws SQLException
	{
		String sqlQuery = "insert into teststudent.user(name, age, contact, email, password) values ('"+user.getName()+"', '"+user.getAge()+"', '"+user.getContact()+"', '"+user.getEmail()+"', '"+user.getPassword()+"');";
		Statement stmt = connection.createStatement();
		return stmt.executeUpdate(sqlQuery);
	}
	
	
	public int updateUser(User user) throws SQLException
	{
		String sqlQuery = "UPDATE teststudent.user SET name = '"+user.getName()+"', age = '"+user.getAge()+"', contact = '"+user.getContact()+"', email = '"+user.getEmail()+"', password = '"+user.getPassword()+"' WHERE id = "+user.getId()+";";
		Statement stmt = connection.createStatement();
		return stmt.executeUpdate(sqlQuery);
	}
	
	public List<User> getAllUsers() throws SQLException 
	{
		List<User> users = new ArrayList<User>();
		String sqlQuery = "Select * from teststudent.user";
		Statement stmt = connection.createStatement();
		ResultSet resultset = stmt.executeQuery(sqlQuery);
		while (resultset.next())
		{
			User user = new User();
			
			user.setId(resultset.getInt("id"));
			user.setName(resultset.getString("name"));
			user.setAge(resultset.getInt("age"));
			user.setContact(resultset.getString("contact"));
			user.setEmail(resultset.getString("email"));
			user.setPassword(resultset.getString("password"));
			users.add(user);
		}
		return users;
	}
	
	public static void main(String[] args) 
	{ 
		try 
		{
			//For Read DataBase
			
			List<User> list = new UserDataLayer().getAllUsers();
			list.forEach(System.out::print);
			
			User user = list .get(1);
			
			user.setAge(user.getAge()+1);
			user.setName(user.getName()+user.getAge()+1);
			user.setContact(user.getContact()+user.getAge()+1);
			user.setEmail(user.getEmail()+user.getAge()+1);
			user.setPassword(user.getPassword()+user.getAge()+1);
			
			System.out.println(new UserDataLayer().updateUser(user));
			
			
			
			//For Create DataBase
			//UserDataLayer dataLayer = new UserDataLayer();
			
			//User user = new User("Ajit", 0, 25, "35435453453", "a@a.com", "123456789");
			
			//System.out.println(dataLayer.saveUser(user));
			
		}
		catch (ClassNotFoundException | SQLException e)
		{	
			e.printStackTrace();
		}
	}
}
