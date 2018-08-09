package hello;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	CustomLogoutSuccessHandler customizeLogoutSuccessHandler;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
	  auth.jdbcAuthentication().dataSource(dataSource)
	  	.usersByUsernameQuery("select username,password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select username, role from user_roles where username=?")
		.passwordEncoder(new BCryptPasswordEncoder()); //有使用密碼加密;
	}	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.authorizeRequests()
		.antMatchers("/hello").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/hello/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_DBA')")
		.anyRequest().permitAll()		
		.and()
		.formLogin().loginPage("/login")
		.usernameParameter("username").passwordParameter("password")
		.and()
		.logout().logoutSuccessUrl("/login?logout")
		.logoutSuccessHandler(customizeLogoutSuccessHandler)
		.and()
		.exceptionHandling().accessDeniedPage("/403")
		.and()
		.csrf();
	}
	
}
