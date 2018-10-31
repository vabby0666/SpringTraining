package springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@Autowired
	Login login;
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginpage()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject(login);
		mav.setViewName("Login");
		return mav;
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView validate(@ModelAttribute("login") Login login)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("log", login);
		mav.setViewName("Welcome");
		return mav;
	}

	
	/*@RequestMapping("/hello")
	public String welcome() {
		return "Welcome";
	}
	@RequestMapping("/login")
	public String showLoginPage() {
		return "Login";
	}
	@RequestMapping("/loginvalidate")
	public String validate(@RequestParam("username") String user, @RequestParam("password") String pass) {
		if(user.equals("admin")&&pass.equals("admin"))
			return "Welcome";
		else
			return "Failed";
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPage() {
		return "Login";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String validate(@ModelAttribute("login") Login login) {
		return "Welcome";
	}
	@RequestMapping(value="/EmpDetails", method=RequestMethod.GET)
	public String EmployeePage() {
		return "EmployeeDetails";
	}
	@RequestMapping(value="/EmpDetails", method=RequestMethod.POST)
	public String EmpDetails(@ModelAttribute("EmployeeDetails") Employee emp)
	{
		System.out.println(emp.getEmpcode()+" "+emp.getEmpname()+" "+emp.getJob()+" "+emp.getSalary()+" "+emp.getDateOfBirth());
		return "Welcome";
	}*/
}
