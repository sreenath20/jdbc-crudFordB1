package com.employee.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.employee.app.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDAO {

	@Override
	public void addEmployee(Employee employee) {

		Connection connection = MySqlUtility.getConnectionToMySQL();
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
	public Employee getEmployeeById(Integer employeeId) {
		Connection connection = MySqlUtility.getConnectionToMySQL();
		String sql = "SELECT * FROM employee WHERE id = ?";

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

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return newEmployee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmployeeById(Integer employeeId) {
		Connection connection = MySqlUtility.getConnectionToMySQL();
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
