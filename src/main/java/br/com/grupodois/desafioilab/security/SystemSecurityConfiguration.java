package br.com.grupodois.desafioilab.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration 			
@EnableWebSecurity 
public class SystemSecurityConfiguration extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
	
	@Autowired
	private SystemEntryPoint entryPoint; 
	
	public void configure(HttpSecurity httpSec) throws Exception{
		
		httpSec.csrf().disable()
					  .exceptionHandling().authenticationEntryPoint(entryPoint).and()
					  .authorizeRequests() 
					  .antMatchers(HttpMethod.POST,"/login").permitAll()
					  .antMatchers(HttpMethod.POST,"/register").permitAll()
					  
					  .anyRequest().permitAll(); //Tirar isso aqui no final!
					  //.anyRequest().authenticated().and().cors();
		
			httpSec.addFilterBefore(new SystemAuthFilter(), UsernamePasswordAuthenticationFilter.class);
			
		}
}
