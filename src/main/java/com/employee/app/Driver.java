package com.employee.app;

import java.sql.Connection;
import java.util.Optional;

import com.employee.app.dao.EmployeeDAO;
import com.employee.app.dao.EmployeeDaoImpl;
import com.employee.app.dao.DaoUtility;
import com.employee.app.dto.Employee;

public class Driver {
	public static void main(String[] args) {

		// EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(); // tight coupling

		// CRUD
		// Create dao using MySql
		// EmployeeDAO employeeDao = new
		// EmployeeDaoImpl(MySqlUtility.getConnectionToMySQL()); // loose coupling

		// Create dao using Oracle
		 EmployeeDAO employeeDao = new EmployeeDaoImpl(DaoUtility.getConnectionToOracle()); // loose coupling

		// employeeDao.addEmployee(new Employee(1, "name1", 25000.0));
		// employeeDao.addEmployee(new Employee(2, "name2", 35000.0));

		// Read
		Optional<Employee> optFoundEmployee = employeeDao.getEmployeeById(1);
		if (optFoundEmployee.isPresent())
			System.out.println(optFoundEmployee.get());
		else
			System.out.println("Employee could not be found for given id");
		
		Optional<Employee> optFoundEmployee2 = employeeDao.getEmployeeById(2);
		if (optFoundEmployee2.isPresent())
			System.out.println(optFoundEmployee2.get());
		else
			System.out.println("Employee could not be found for given id");

		// delete
		// employeeDao.deleteEmployeeById(1);
		// employeeDao.deleteEmployeeById(2);
		// update employee
		// employeeDao.addEmployee(new Employee(3, "name3", 35000.0));
		Employee updateEmployee = new Employee(3, "Ford", 55000.0);
		employeeDao.updateEmployee(updateEmployee);
		
		Optional<Employee> optFoundEmployee3 = employeeDao.getEmployeeById(3);
		if (optFoundEmployee3.isPresent())
			System.out.println(optFoundEmployee3.get());
		else
			System.out.println("Employee could not be found for given id");

	}

}
