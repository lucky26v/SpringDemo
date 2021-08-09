package service;

import java.util.ArrayList;

import model.Employee;


public interface EmployeeService {

	
    public void add(Employee employee);
	
	public ArrayList<Employee> getEmployeesList();
	
	public void deleteEmployeeRecord(String userName);
	
	public void updateEmployeeRecord(Employee employee);

	public Employee getEmployeeRecord(String userName);
}
