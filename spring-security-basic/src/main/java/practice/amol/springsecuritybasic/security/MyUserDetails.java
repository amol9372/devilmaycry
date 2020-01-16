package practice.amol.springsecuritybasic.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import practice.amol.springsecuritybasic.security.model.User;

@SuppressWarnings("serial")
public class MyUserDetails implements UserDetails{

	private User user;
	
	public MyUserDetails(User user) {
         this.user = user;
	}
	
	public MyUserDetails(){
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String[] authorities = user.getRoles().split(",");
		List<SimpleGrantedAuthority> authorityList = Arrays.stream(authorities).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		return authorityList;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserName();
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
		return user.isActive();
	}
   
}
