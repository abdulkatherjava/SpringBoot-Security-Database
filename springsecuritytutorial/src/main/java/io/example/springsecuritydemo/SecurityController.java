package io.example.springsecuritydemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	
	@RequestMapping("home")
	public String getMessage() {
		return "index";
	}

}
