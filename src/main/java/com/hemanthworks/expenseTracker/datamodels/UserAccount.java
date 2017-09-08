package com.hemanthworks.expenseTracker.datamodels;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAccount
{
	@Id
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String emailId;
	private boolean enabled;
	
	public UserAccount()
	{
		
	}
	
	public UserAccount(String username, String password, String firstName, String lastName, String emailId)
	{
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.enabled = true;
	}
	public String getUsername ()
	{
		return username;
	}
	public void setUsername ( String username )
	{
		this.username = username;
	}
	public String getPassword ()
	{
		return password;
	}
	public void setPassword ( String password )
	{
		this.password = password;
	}
	public String getFirstName ()
	{
		return firstName;
	}
	public void setFirstName ( String firstName )
	{
		this.firstName = firstName;
	}
	public String getLastName ()
	{
		return lastName;
	}
	public void setLastName ( String lastName )
	{
		this.lastName = lastName;
	}
	public String getEmailId ()
	{
		return emailId;
	}
	public void setEmailId ( String emailId )
	{
		this.emailId = emailId;
	}
	public boolean isEnabled ()
	{
		return enabled;
	}
	public void setEnabled ( boolean enabled )
	{
		this.enabled = enabled;
	}
}
