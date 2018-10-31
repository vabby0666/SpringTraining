package springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeValidations validations;
	@Autowired
	Employee employee;
	@RequestMapping(value="/addempl", method=RequestMethod.GET)
	public ModelAndView showEmplForm() {
		ModelAndView mav=new ModelAndView();
		mav.addObject(employee);
		mav.setViewName("AddEmpl");
		return mav;
	}
	@RequestMapping(value="/addempl", method=RequestMethod.POST)
	public ModelAndView addEmpl(@ModelAttribute("employee") Employee emp, BindingResult result) {
		ModelAndView mav=new ModelAndView();
		validations.validate(emp,result);
		if(result.hasErrors()) {
			mav.setViewName("AddEmpl");
			return mav;
		}
		mav.addObject("emp",emp);
		mav.setViewName("Success");
		return mav;
	}	
}