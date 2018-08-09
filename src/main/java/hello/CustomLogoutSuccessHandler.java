/*
 * 取得 spring security 登出後事件
 */

package hello;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
 
@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler{
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// Code For Business Here
		//logger.info("Logout Sucessfull with Principal: " + authentication.getName());
		
		try {		
			String userName = authentication.getName();		
			System.out.println("logout user: " + userName);
		} catch (Exception e) {
			//
		}
		
		//response.setStatus(HttpServletResponse.SC_OK);
        //redirect to login
		response.sendRedirect("/login?logout");
	}
	
}