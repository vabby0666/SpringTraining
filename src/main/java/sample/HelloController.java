package sample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello Spring Boot";
	}
	@RequestMapping("/welcome")
	public String welcome() {
		return "Welcome Spring Boot";
	}
}
