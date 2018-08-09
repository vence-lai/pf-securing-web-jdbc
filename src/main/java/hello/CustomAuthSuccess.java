/*
 * 取得 spring security 的正確驗證後事件
 */

package hello;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthSuccess implements ApplicationListener<AuthenticationSuccessEvent> {

	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent event) {
		// TODO Auto-generated method stub
		
		String userName = event.getAuthentication().getName();
		
		System.out.println("login user: " + userName);
		
	}
	
	// 將資料庫裡 user 的 password 欄位用此方法加密, 
	// Spring security 才可用密碼自動加解密檢查是否為合格的登入者
	public String passwordEncode(String encval) {
		String cryptedPassword = new BCryptPasswordEncoder().encode(encval);
		//System.out.println(cryptedPassword);
		
		return cryptedPassword;
	}
}
