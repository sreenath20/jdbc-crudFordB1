package com.employee.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.employee.app.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDAO {

	private Connection connection;

	public EmployeeDaoImpl(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public void addEmployee(Employee employee) {

		// Connection connection = MySqlUtility.getConnectionToMySQL();
		String sql = "INSERT INTO employee (id,name,salary) VALUES(?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setDouble(3, employee.getSalary());
			System.out.println(preparedStatement);
			Integer count = preparedStatement.executeUpdate();
			if (count == 1)
				System.out.println("Employee added successfully to DB.");
			else
				System.out.println("Employee coud not be added to DB.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// add the records

	}

	@Override
	public Optional<Employee> getEmployeeById(Integer employeeId) {
		// Connection connection = MySqlUtility.getConnectionToMySQL();
		String sql = "SELECT * FROM employee WHERE id = ?";
		Optional<Employee> optEmployee;
		
		Employee newEmployee = null; // return null if emp does not exists for id
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employeeId);
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				// if employee exists for given id

				// Employee(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3));
				newEmployee = new Employee(resultSet.getInt("id"), resultSet.getString("name"),
						resultSet.getDouble("salary"));
				optEmployee = Optional.of(newEmployee);
				return optEmployee;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		optEmployee= Optional.empty();
		
		return optEmployee;
	}

	@Override
	public void updateEmployee(Employee updateEmployee) {
		// Connection connection = MySqlUtility.getConnectionToMySQL();
		String sql = "UPDATE employee set name = ? , salary = ? WHERE id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, updateEmployee.getName());
			preparedStatement.setDouble(2, updateEmployee.getSalary());
			preparedStatement.setInt(3, updateEmployee.getId());
			Integer count = preparedStatement.executeUpdate();
			if (count == 1)
				System.out.println("Employee updated.");
			else
				System.out.println("Employee could not be updated.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteEmployeeById(Integer employeeId) {
		// Connection connection = MySqlUtility.getConnectionToMySQL();
		String sql = "DELETE FROM employee WHERE id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employeeId);
			// System.out.println(preparedStatement);
			Integer count = preparedStatement.executeUpdate();

			if (count == 1) {
				System.out.println("Employee deleted Successfully for id:" + employeeId);
			} else
				System.out.println("Employee could not be deleted for id:" + employeeId);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}
