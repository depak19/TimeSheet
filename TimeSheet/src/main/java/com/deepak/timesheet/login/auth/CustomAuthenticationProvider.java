package com.deepak.timesheet.login.auth;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.deepak.timesheet.login.model.User;
import com.deepak.timesheet.login.model.UserProfile;
import com.deepak.timesheet.login.service.UserProfileService;
import com.deepak.timesheet.login.service.UserService;
import com.deepak.timesheet.util.EncodeAndDecode;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	static final Logger logger = Logger.getLogger(CustomAuthenticationProvider.class);
	@Autowired
	private UserService userService;
	@Autowired
	private UserProfileService userProfileService;

	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String ssoId = authentication.getName().toUpperCase();
		String password = (String) authentication.getCredentials();
		User user = userService.findBySso(ssoId);

		if (user == null) {
			throw new BadCredentialsException("Username not found.");
		}
		if (!EncodeAndDecode.cryptWithMD5(password).equals(user.getPassword())) {
			throw new BadCredentialsException("Wrong password.");
		}
		return new UsernamePasswordAuthenticationToken(ssoId, password,
				getGrantedAuthorities(user));
	}

	public boolean supports(Class<?> arg0) {
		return true;
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (UserProfile userProfile : user.getUserProfiles()) {
			authorities.add(new SimpleGrantedAuthority(userProfile.getType()));
		}
		return authorities;
	}

}