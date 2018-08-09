package hello;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")

public class mycontroller {
	
	@RequestMapping("/hello")
	public String greeting(HttpServletResponse response) {
		
		response.setHeader("udf_header", "Vence");
		
		// 回傳網頁
		return "hello";
				
	}
	
	
	@RequestMapping("/hello/test")
	public String greeting2(HttpServletResponse response) {
		
		// 回傳網頁
		return "test";
				
	}

}
