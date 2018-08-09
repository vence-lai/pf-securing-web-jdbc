package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        //registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/403").setViewName("403");
    }
    
    @Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/userbase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&useSSL=false&serverTimezone=UTC");
	    driverManagerDataSource.setUsername("root");
	    driverManagerDataSource.setPassword("1qaz2wsx");
	    return driverManagerDataSource;
	}
    
    @Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
    
    /* database : userbase
      
      CREATE  TABLE users (
  		username VARCHAR(45) NOT NULL ,
  		password VARCHAR(45) NOT NULL ,
  		enabled TINYINT NOT NULL DEFAULT 1 ,
  	  PRIMARY KEY (username));
   
CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));
 
INSERT INTO users(username,password,enabled)
VALUES ('priya','priya', true);
INSERT INTO users(username,password,enabled)
VALUES ('naveen','naveen', true);
 
INSERT INTO user_roles (username, role)
VALUES ('priya', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('priya', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('naveen', 'ROLE_USER');
      
     */
    
        
   
    
     
}