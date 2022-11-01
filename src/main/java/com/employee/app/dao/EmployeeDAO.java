package com.employee.app.dao;

import com.employee.app.dto.Employee;

public interface EmployeeDAO {
	// CRUD
	void addEmployee(Employee employee);

	Employee getEmployeeById(Integer employeeId);

	void updateEmployee(Employee employee);

	void deleteEmployeeById(Integer employeeId);

}
