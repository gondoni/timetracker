package com.timetracker.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.timetracker.entity.User;

public class UserDetailsImpl implements UserDetails {
	
	private static final long serialVersionUID = 3185970362329652833L;
	private User user;
	
	public UserDetailsImpl(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
//		Set<Role> roles = user.getRoles();
//		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority("USER"));
//		}
		return authorities;
	}

	@Override
	public String getPassword() {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder(); 
        return encoder.encode(this.user.getPassword());
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
