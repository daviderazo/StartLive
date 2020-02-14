/**
 * 
 */
package com.dav.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dav.model.Usuario;
import com.dav.repositorio.UsuarioRep;

/**
 * @author Dhartel
 *
 */

@Service
public class UserServices implements UserDetailsService{

	@Autowired
	private UsuarioRep repositorio;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario ul = repositorio.findByNombre(username); 
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		
		//UserDetails userDetails = new User(ul.getNombre(), ul.getContrasena(), roles );
		return new User(ul.getNombre(), ul.getContrasena(), roles );
	}

}
