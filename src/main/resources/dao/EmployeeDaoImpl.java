package dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import model.Employee;


public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	DataSource datasource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void addEmployeeData(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("Inserting new employee");
		String sql="insert into employees values(?,?,?,?,?,?,?)";
		jdbcTemplate.setDataSource(datasource);
		jdbcTemplate.update(sql, new Object[] {employee.getUserName(),employee.getPassword(),employee.getFirstName(),employee.getLastName(),
				employee.getEmailId(),employee.getAddress(),employee.getMobileNumber()});
	}

	public ArrayList<Employee> getEmployeesList() {
		 String sql = "SELECT * FROM employees";
		 ArrayList<Employee> employees = (ArrayList<Employee>)jdbcTemplate.query(sql,new BeanPropertyRowMapper<Employee>(Employee.class));
		return employees;
	}

	public void deleteEmployeeRecord(String userName) {
		System.out.println("Deleting the user in the database");
		String deleteQuery = "delete from employees where userName=?";
		jdbcTemplate.update(deleteQuery, userName);
	}

	public void updateEmployeeRecord(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("Updating in database");
        String sql = "update employees set userName=?, Password=?, firstName=?, lastName=?, emailId=?, Address=?, MobileNumber=? where userName=?";
        jdbcTemplate.update(sql, new Object[]{employee.getUserName(),employee.getPassword(), employee.getFirstName(), employee.getLastName(), 
        		employee.getEmailId(), employee.getAddress(),employee.getMobileNumber(), employee.getUserName() });
        System.out.println("Updated Employee record sucessfully");
		
	}

	public Employee getEmployeeRecord(String userName) {
		System.out.println("Called get Employee Record");
		 String sql="select * from employees where userName=?";    
		 return jdbcTemplate.queryForObject(sql, new Object[]{userName},new BeanPropertyRowMapper<Employee>(Employee.class));    
	}

}
