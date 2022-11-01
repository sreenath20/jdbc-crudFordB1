package com.employee.app.dao;

import java.util.Optional;

import com.employee.app.dto.Employee;

public interface EmployeeDAO {
	// CRUD
	void addEmployee(Employee employee);

	Optional<Employee> getEmployeeById(Integer employeeId);

	void updateEmployee(Employee employee);

	void deleteEmployeeById(Integer employeeId);

}
