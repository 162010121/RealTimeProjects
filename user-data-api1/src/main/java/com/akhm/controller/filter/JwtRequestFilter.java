package com.akhm.controller.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.akhm.service.impl.JwtUserDetailsServiceImpl;
import com.akhm.util.JwtTokenUtil;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUserDetailsServiceImpl jwtUserDetailsServiceImpl;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException
	{
		final String requestTokenHeader=request.getHeader("Authrization");
		
		String userName=null;
		String jwtToken=null;
		
		if(requestTokenHeader !=null && requestTokenHeader.startsWith("Bearer "))
		{
			
			jwtToken=requestTokenHeader.substring(7);
			try {
				
				userName=jwtTokenUtil.getUserNameFromToken(jwtToken);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else
		{
			log.warn("JwtTokenDoes't begin with bearer String");
		}
		if (userName !=null & SecurityContextHolder.getContext().getAuthentication()==null )
		{
			UserDetails userDetails=this.jwtUserDetailsServiceImpl.loadUserByUsername(userName);
			if (jwtTokenUtil.validateToken(jwtToken, userDetails))
			{
				UsernamePasswordAuthenticationToken userNamePassword= new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				
				userNamePassword.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(userNamePassword);
				
				
			}
			
			
		}
		filterChain.doFilter(request, response);
		
		
		
		
	}
	
	

}
