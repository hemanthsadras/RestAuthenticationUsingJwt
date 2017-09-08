package com.hemanthworks.expenseTracker.jwt;

import com.hemanthworks.expenseTracker.datamodels.UserAccount;

public class JwtUserFactory
{
	public static JwtUser getJwtUser(UserAccount userAccount)
	{
		return new JwtUser(userAccount);
	}
}
