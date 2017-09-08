package com.hemanthworks.expenseTracker.datamodels;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable
{

	private static final long serialVersionUID = -2919981550983087197L;
	
	private String token;

	public String getToken ()
	{
		return token;
	}

	public void setToken ( String token )
	{
		this.token = token;
	}
}
