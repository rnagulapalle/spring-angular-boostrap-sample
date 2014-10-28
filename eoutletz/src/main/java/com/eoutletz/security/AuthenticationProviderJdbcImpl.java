package com.eoutletz.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.eoutletz.domain.User;
import com.eoutletz.repository.UserRepository;

@Component("authenticationProviderJdbcImpl")
public class AuthenticationProviderJdbcImpl implements AuthenticationProvider
{
	@Inject
	private UserRepository userRepository;
		
	@Override
	@Transactional(readOnly=true)
	public Authentication authenticate(Authentication authentication) throws AuthenticationException 
	{
		String username = authentication.getName();
        User user = userRepository.findByEmail(username);
        
        if(user == null)
		{
			throw new UsernameNotFoundException("User name " + username + " not found");
		}
		
        String password = authentication.getCredentials().toString();
        
        if(BCrypt.checkpw(password, user.getPassword()))
        {
        	return new UsernamePasswordAuthenticationToken(username, password, getAuthorities(user));
        }
        else
        {
        	throw new BadCredentialsException("Invalid username and/or password");
        }
	}
	
	private Collection<GrantedAuthority> getAuthorities(User user)
	{
		List<GrantedAuthority> authorities = new ArrayList<>();  

		if(user != null)
		{
				authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		
		return authorities;
	}
	
	
	@Override
	public boolean supports(Class<?> authentication)
	{
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
