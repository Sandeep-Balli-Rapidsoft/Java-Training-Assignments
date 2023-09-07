package jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/welcome")
	public String welcome() {
		String text = "this is a private page";
		text+= "this page is not allowed to unauthenticated users";
		return text;
	}
	
	@RequestMapping("/success")
	public String forAll() {
		String text = "Hello User. You have logged in sucessfully";
		return text;
	}
}
