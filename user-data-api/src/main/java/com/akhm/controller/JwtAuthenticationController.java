package com.akhm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akhm.model.JwtRequest;
import com.akhm.model.JwtResponce;
import com.akhm.service.impl.JwtUserDetailsServiceImpl;
import com.akhm.util.JwtTokenUtil;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsServiceImpl userDetailsService;
	
	private void authenticate(String userName,String password) throws Exception
	{
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest request)throws Exception
	{
		authenticate(request.getUseName(),request.getPassword());
		
		final UserDetails userDetails=userDetailsService.loadUserByUsername(request.getUseName());
		final String token=jwtTokenUtil.generateToken(userDetails);
		
		
		
		return ResponseEntity.ok(new JwtResponce(token));
	}

}
