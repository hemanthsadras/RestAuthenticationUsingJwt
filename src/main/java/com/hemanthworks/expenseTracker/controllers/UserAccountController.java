package com.hemanthworks.expenseTracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hemanthworks.expenseTracker.datamodels.UserAccount;
import com.hemanthworks.expenseTracker.services.UserAccountService;

@RestController
public class UserAccountController
{
	@Autowired
	private UserAccountService userAccountService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/account")
	public UserAccount createUserAccount(@RequestBody UserAccount userAccount)
	{
		return userAccountService.createUserAccount(userAccount);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/account/{username}")
	public UserAccount getUserAccountByUserName(@PathVariable("username") String username)
	{
		return userAccountService.getUserAccountByUserName(username);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/account")
	public List<UserAccount> getAllUserAccounts()
	{
		return userAccountService.getAllUserAccounts();
	}
}
