package practice.amol.springsecuritybasic.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * auth.inMemoryAuthentication() .withUser("amol") .password("singh")
		 * .roles("USER") .and() .withUser("admin") .password("admin") .roles("ADMIN");
		 */
		/*
		 * auth.jdbcAuthentication() .dataSource(dataSource);
		 */
		  /*.withDefaultSchema() 
		    .withUser(
		    		  User.withUsername("amol")
		    		      .password("singh")
		    		      .roles("USER")
		    ).withUser(
		    		  User.withUsername("admin")
	    		      .password("singh")
	    		      .roles("ADMIN")
	        );	     */
		 auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
           .antMatchers("/admin").hasAnyRole("ADMIN", "USER")            // NEED TO ADD ROLE AS PREFIX IN DB
           .antMatchers("/user").hasRole("USER")
           .antMatchers("/").permitAll()
           .and().formLogin();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}