package jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	/*@Autowired
	EmployeeValidations validations;*/
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
	@RequestMapping(value="/updateempl", method=RequestMethod.GET)
	public ModelAndView updateEmpl(@RequestParam("code") int code) {
		ModelAndView mav=new ModelAndView();
		Employee empList=dao.getEmp(code);
		mav.addObject("employee",empList);
		mav.setViewName("UpdateEmpl");
		return mav;
	}
	@RequestMapping(value="/updateempl", method=RequestMethod.POST)
	public ModelAndView updateEmpl(@ModelAttribute("employee") Employee emp) {
		ModelAndView mav=new ModelAndView();
		dao.updateEmpl(emp);
		List<Employee> empList=dao.getEmpls();
		mav.addObject("list",empList);
		mav.setViewName("ViewEmpls");
		return mav;
	}
	@RequestMapping(value="/deleteempl")
	public ModelAndView deleteEmpl(@RequestParam("code") int code) {
		ModelAndView mav=new ModelAndView();
		dao.delEmpl(code);
		List<Employee> empList=dao.getEmpls();
		mav.addObject("list",empList);
		mav.setViewName("ViewEmpls");
		return mav;
	}
}