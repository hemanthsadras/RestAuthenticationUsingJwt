package com.hemanthworks.expenseTracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hemanthworks.expenseTracker.datamodels.UserAccount;
import com.hemanthworks.expenseTracker.jwt.JwtUserFactory;
import com.hemanthworks.expenseTracker.repositories.UserAccountRepository;

@Service
public class UserAccountService implements UserDetailsService
{
	@Autowired
	private UserAccountRepository userAccountRepository;

	@Override
	public UserDetails loadUserByUsername ( String username ) throws UsernameNotFoundException
	{
		UserAccount userAccount = userAccountRepository.findByUsername(username);
		if(userAccount != null)
		{
			return JwtUserFactory.getJwtUser(userAccount);
		}
		else
		{
			throw new UsernameNotFoundException("no user found with - " + username);
		}
		
	}
	
	public UserAccount createUserAccount(UserAccount userAccount)
	{
		//TODO : verify that no user already exists with same username
		return userAccountRepository.save(userAccount);
	}
	
	public UserAccount getUserAccountByUserName(String userName)
	{
		return userAccountRepository.findByUsername(userName);
	}
	
	public List<UserAccount> getAllUserAccounts()
	{
		return userAccountRepository.findAll();
	}

}
