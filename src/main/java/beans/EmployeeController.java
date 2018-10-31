package beans;

import java.util.List;
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
	Employee empl;
	@Autowired
	EmployeeDao dao;
	
	@RequestMapping(value="/addempl", method=RequestMethod.GET)
	public ModelAndView showEmplForm() {
		ModelAndView mav=new ModelAndView();
		mav.addObject(empl);
		mav.setViewName("AddEmpl");
		return mav;
	}
	
	@RequestMapping(value="/addempl", method=RequestMethod.POST)
	public ModelAndView addEmpl(@ModelAttribute("employee") Employee emp, BindingResult result) {
		ModelAndView mav=new ModelAndView();
		//validations.validate(emp,result);
		int rows=dao.addEmpl(emp);
		if(rows>0) {
			String msg=rows+" Record(s) inserted";
			mav.addObject("msg",msg);
			mav.setViewName("Success");
			return mav;
		}
		return mav;
	}
	
	@RequestMapping(value="/viewempls")
	public ModelAndView employeeList() {
		ModelAndView mav=new ModelAndView();
		List<Employee> empList=dao.getEmpls();
		mav.addObject("list",empList);
		mav.setViewName("ViewEmpls");
		return mav;
	}
	
}