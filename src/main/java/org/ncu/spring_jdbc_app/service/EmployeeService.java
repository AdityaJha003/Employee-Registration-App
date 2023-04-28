package org.ncu.spring_jdbc_app.service;

import java.util.List;

import org.ncu.spring_jdbc_app.entity.Employee;

public interface EmployeeService {
	public String createRecord(Employee emp);
	public int updateRecord(int empId);
	public int deleteRecord(int empId);
	public Employee fetchEmployee(int empId);
	public List<Employee> loadEmployees();
	
	public void batchInsertRecord(List<Employee> emps);
	public List<Employee> Sortbysalarya();
	public List<Employee> Sortbysalaryd();
}	
