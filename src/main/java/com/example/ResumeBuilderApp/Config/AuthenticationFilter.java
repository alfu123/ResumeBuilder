package com.example.ResumeBuilderApp.Config;

import com.example.ResumeBuilderApp.Util.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationFilter extends OncePerRequestFilter{

	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private jwtUtils jwtUtils;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String requestTokenHeader =request.getHeader("Authorization");
		String username=null;
		String jwtToken=null;

		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken=requestTokenHeader.substring(7);

			try {
				
				username=jwtUtils.extractUsername(jwtToken);

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		//Security
		UserDetails userDetials   =this.customUserDetailsService.loadUserByUsername(username);
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetials,null,userDetials.getAuthorities());
			
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		
		
		
		}
		else
		{
			System.out.println("Token is not validated...");
		}
		}
	
		filterChain.doFilter(request,response);
	}
}
