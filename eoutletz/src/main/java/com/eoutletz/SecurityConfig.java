package com.eoutletz;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Inject
	@Named("authenticationProviderJdbcImpl")
	private AuthenticationProvider authenticationProvider;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(authenticationProvider);	
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception{
		http.formLogin()
						.loginPage("/login")
						.defaultSuccessUrl("/home")
						.failureUrl("/login?error=1")
						.usernameParameter("username")
						.passwordParameter("password")
						.permitAll();
		
		// Http URL Filters
        http.authorizeRequests()
                		.antMatchers("/resources/**", "/styles/**", "/static/**", "/webjars/**", "/signup", "/login/**", 
                				"/images/**", "/scripts/**", "/product/**", "/partner", "/forgotpassword", "/resetpassword").permitAll()
                		.antMatchers("/api/*").permitAll()	
                		.antMatchers("/index.html").permitAll()
                		.antMatchers("/admin/**").hasAnyAuthority("ADMIN")
        				.anyRequest().authenticated();
		
        // Disable the CSRF checking
        http.csrf().disable();
    }
}
