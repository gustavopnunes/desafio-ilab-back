package br.com.grupodois.desafioilab.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration 			
@EnableWebSecurity 
public class SystemSecurityConfiguration extends WebSecurityConfigurerAdapter {
		
	@Autowired
	private SystemEntryPoint entryPoint; 
	
	public void configure(HttpSecurity httpSec) throws Exception{
		
		httpSec.csrf().disable()
					  .exceptionHandling().authenticationEntryPoint(entryPoint).and()
					  .authorizeRequests() 
					  .antMatchers(HttpMethod.POST, "/login").permitAll()
					  .antMatchers(HttpMethod.POST, "/register").permitAll()
					  .antMatchers(HttpMethod.GET, "/v2/api-docs").permitAll()
					  .antMatchers(HttpMethod.GET, "/swagger-ui.html").permitAll()
					  .anyRequest().authenticated().and().cors();
		
			httpSec.addFilterBefore(new SystemAuthFilter(), UsernamePasswordAuthenticationFilter.class);
			
		}
	
	
	@Override
	public void configure(final WebSecurity webSecurity) {
		webSecurity.ignoring().antMatchers(
				 	"/v2/api-docs", 
		            "/swagger-resources/**",  
		            "/swagger-ui.html", 
		            "/webjars/**" ,
		            "/swagger.json");
	}

}
