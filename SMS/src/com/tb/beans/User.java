package com.tb.beans;

public class User
{
	private String name;
	private int id;
	private int age;
	private String contact;
	private String email;
	private String password;
	
	public User(String name, int id, int age, String contact, String email, String password) 
	{
		super();
		this.name = name;
		this.id = id;
		this.age = age;
		this.contact = contact;
		this.email = email;
		this.password = password;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() 
	{
		return "User [name=" + name + ", id=" + id + ", age=" + age + ", contact=" + contact + ", email=" + email
				+ ", password=" + password + "]";
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	public String getContact() 
	{
		return contact;
	}
	public void setContact(String contact) 
	{
		this.contact = contact;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
}
