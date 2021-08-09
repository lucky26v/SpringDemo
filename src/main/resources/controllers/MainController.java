package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import model.Employee;
import model.LoginCredentials;
import service.EmployeeService;

@Controller
public class MainController 
{
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value="/login.htm", method = RequestMethod.GET)
	public String gotoLogin() 
	{
	System.out.println("Called Login");
	return "login";
	}
	
	
	@RequestMapping(value="/register.htm", method = RequestMethod.GET)
	public String gotoRegister() 
	{
	System.out.println("Called Register");
	return "register";
	}
	
	@RequestMapping(value="/loginRequest", method = RequestMethod.GET)
	public ModelAndView gotologinwelcome(HttpServletRequest request,HttpServletResponse response,
			@ModelAttribute("LoginCredentials") LoginCredentials credentials) 
	{
	System.out.println("Verifying Username and password");
	if(credentials.getUserName().equalsIgnoreCase("admin")) {
		System.out.println("Admin Trying to login");
		try {
			Employee employee  = employeeService.getEmployeeRecord(credentials.getUserName());
			if(employee.getPassword().equals(credentials.getPassword())) {
				List<Employee> employees = employeeService.getEmployeesList();
				System.out.println("Employee List:"+employees);
				return new ModelAndView("employeeList","list",employees);
			}else {
				String message = "Incorrect Password! Please check your password and try again";
				return new ModelAndView("errorPage","message",message);
			}
		}catch (Exception e) {
			String message = "User Not Found! \n Please Check your credentials and try again";
			return new ModelAndView("errorPage","message",message);
		}
	}else {
		String message = "Only Admin have the Acess";
		return new ModelAndView("errorPage","message",message);
	}
}
	

	
	@RequestMapping(value="/addNewEmployee", method = RequestMethod.POST)
	public ModelAndView addNewEmployee(HttpServletRequest request,HttpServletResponse response, @ModelAttribute("employee") Employee employee) 
	{
		System.out.println("Called addNewEmployee");
		System.out.println("Employee Data:"+employee.toString());
		employeeService.add(employee);
		return new ModelAndView("registerwelcome","firstName",employee.getFirstName());
	}
	
	
	@RequestMapping(value="/updateRecord", method = RequestMethod.POST)
	public String updateEmployee(HttpServletRequest request,HttpServletResponse response, @ModelAttribute Employee employee) 
	{
		System.out.println("Called Update Employee");
		System.out.println("Updating employee:"+employee.toString());
		employeeService.updateEmployeeRecord(employee);
		return "login";
		/*List<Employee> employees = employeeService.getEmployeesList();
		System.out.println("Employee List:"+employees);
		return new ModelAndView("employeeList","list",employees);*/
	}
	
	
	
	
	@RequestMapping(value="/showEmployees.htm",method=RequestMethod.GET)
	public ModelAndView showAllEmployees() {
		System.out.println("Called show employees method");
		List<Employee> employees = employeeService.getEmployeesList();
		System.out.println("Employee List:"+employees);
		return new ModelAndView("employeeList","list",employees);
	}
	
	 /* It deletes record for the given id in URL and redirects to /viewemp */    
    @RequestMapping(value="/deleteemp/{userName}",method = RequestMethod.GET)    
    public ModelAndView delete(@PathVariable String userName){    
        System.out.println("Delete employee:"+userName);   
        employeeService.deleteEmployeeRecord(userName);
        List<Employee> employees = employeeService.getEmployeesList();
		System.out.println("Employee List:"+employees);
		return new ModelAndView("employeeList","list",employees);    
    } 
    
        
    @RequestMapping(value="/editemp/{userName}", method=RequestMethod.GET)    
    public ModelAndView edit(@PathVariable String userName){
    	System.out.println("User name is: "+userName);
        Employee employee = employeeService.getEmployeeRecord(userName);   
    	return new ModelAndView("editPage","employee",employee);
    }
 
    @RequestMapping(value="/modify", method=RequestMethod.GET)
    public ModelAndView modifyRecord(HttpServletRequest request,HttpServletResponse response, @ModelAttribute("employee") Employee employee) {
    	System.out.println("Called Modify Record Method");
    	employeeService.updateEmployeeRecord(employee);
    	List<Employee> employees = employeeService.getEmployeesList();
    	System.out.println("Employee List:"+employees);
    	return new ModelAndView("employeeList","list",employees);
    }
}

