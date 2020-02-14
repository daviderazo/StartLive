/**
 * 
 */
package com.dav.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dav.services.UserServices;

/**
 * @author Dhartel
 *
 */
@Configuration
@EnableWebSecurity  
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	//Necesario para evitar que la seguridad se aplique a los resources
    //Como los css, imagenes y javascripts
    String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
    };
    
	@Autowired
	private UserServices usuarioDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder byCrytEncode;
	
	@Bean
	public BCryptPasswordEncoder passwordEncode(){
		BCryptPasswordEncoder bCryptPAsswordEncoder = new BCryptPasswordEncoder();
		
		return  bCryptPAsswordEncoder;
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("user").password("password").roles("USER")
//		.and().withUser("admin").password("admin").roles("USER", "ADMIN");
		auth.userDetailsService(usuarioDetailsService).passwordEncoder(byCrytEncode);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http 
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/admin/")
		.failureUrl("/login?error=true")
		.usernameParameter("username")
		.passwordParameter("password")
		.and()
		.logout()
		.permitAll()
		.logoutSuccessUrl("/login?logout")
		.and()
		.httpBasic()
		
//        .anantMatchers(resources).permitAll()  
//        .antMatchers("/","/index").permitAll()
//        .antMatchers("/admin*").access("hasRole('ADMIN')")
//        .antMatchers("/user*").access("hasRole('USER') or hasRole('ADMIN')")
//        .anyRequest().authenticated()
//        .and()
//    .formLogin()
//        .loginPage("/login")
//        .permitAll()
//        .defaultSuccessUrl("/admin")
//        .failureUrl("/login?error=true")
//        .usernameParameter("username")
//        .passwordParameter("password")
//        .and()
//    .logout()
//        .permitAll()
//        .logoutSuccessUrl("/login?logout")
        ;
        
	}
}

