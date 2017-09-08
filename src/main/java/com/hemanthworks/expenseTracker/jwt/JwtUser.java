package com.hemanthworks.expenseTracker.jwt;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hemanthworks.expenseTracker.datamodels.UserAccount;

public class JwtUser implements UserDetails
{
	private static final long serialVersionUID = 4819730184174499348L;
	private UserAccount userAccount;
	
	public JwtUser(UserAccount userAccount)
	{
		this.userAccount = userAccount;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities ()
	{
		return null;
	}

	@Override
	public String getPassword ()
	{
		return this.userAccount.getPassword();
	}

	@Override
	public String getUsername ()
	{
		return this.userAccount.getUsername();
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired ()
	{
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked ()
	{
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired ()
	{
		return true;
	}

	@Override
	public boolean isEnabled ()
	{
		return true;
	}

}
