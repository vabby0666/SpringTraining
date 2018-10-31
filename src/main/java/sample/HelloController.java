package sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	ModelAndView mav;
	String message;
	@RequestMapping(value="/welcome", method=RequestMethod.POST)
	public ModelAndView welcome(@RequestParam("username") String username) {
		mav=new ModelAndView();
		username="Welcome "+username;
		mav.addObject("msg",username);
		mav.setViewName("Welcome");
		return mav;
	}
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public ModelAndView welcome() {
		mav=new ModelAndView();
		mav.setViewName("Login");
		return mav;
	}
}
