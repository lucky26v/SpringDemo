package dao;

import java.util.ArrayList;

import model.Employee;


public interface EmployeeDao {
	
	public void addEmployeeData(Employee employee);
	
	public ArrayList<Employee> getEmployeesList();
	
	public void deleteEmployeeRecord(String userName);
	
	public void updateEmployeeRecord(Employee employee);

	public Employee getEmployeeRecord(String userName);
	

}
