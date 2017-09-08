package com.hemanthworks.expenseTracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hemanthworks.expenseTracker.datamodels.AuthenticationRequest;
import com.hemanthworks.expenseTracker.datamodels.AuthenticationResponse;
import com.hemanthworks.expenseTracker.jwt.JwtTokenUtil;

@RestController
public class AuthenticationController
{
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@RequestMapping(method = RequestMethod.POST, value = "/auth")
	public AuthenticationResponse signIn(@RequestBody AuthenticationRequest authenticationRequest, Device device)
	{
		final Authentication authentication = authenticationManager.authenticate(
		        new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
		                authenticationRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Reload password post-security so we can generate token
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails, device);
		
		AuthenticationResponse response = new AuthenticationResponse();
		response.setToken(token);
		return response;
	}
}
