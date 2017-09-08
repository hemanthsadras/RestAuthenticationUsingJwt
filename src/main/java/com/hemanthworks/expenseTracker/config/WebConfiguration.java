package com.hemanthworks.expenseTracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hemanthworks.expenseTracker.security.AuthenticationTokenFilter;
import com.hemanthworks.expenseTracker.security.ETAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class WebConfiguration extends WebSecurityConfigurerAdapter
{
	@Autowired
	private ETAuthenticationEntryPoint unauthorizedEntryPoint;
	
	@Autowired
	private UserDetailsService userDetailsService;
	 
	@Autowired
	public void configureAuthentication ( AuthenticationManagerBuilder authenticationManagerBuilder ) throws Exception
	{
		authenticationManagerBuilder.userDetailsService(this.userDetailsService);
	}
	
	@Bean
	public AuthenticationTokenFilter authenticationTokenFilterBean () throws Exception
	{
		return new AuthenticationTokenFilter();
	}

	@Override
	protected void configure ( HttpSecurity httpSecurity ) throws Exception
	{
		httpSecurity.
					csrf()
					.disable()
					.exceptionHandling()
					.authenticationEntryPoint(unauthorizedEntryPoint).and()
					.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, 
								  "/auth",
								  "/account")
					.permitAll()
					.anyRequest()
					.authenticated();
		
		
		httpSecurity
        			.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
		httpSecurity.headers().cacheControl();

	}
}
