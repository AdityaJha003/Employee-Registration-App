package org.ncu.spring_jdbc_app.dao;

import java.util.List;

import org.ncu.spring_jdbc_app.entity.Employee;

public interface EmployeeDao {
	public int insertEmployee(Employee emp);
	public int deleteEmployee(int empId);
	public int updateEmployee(int empId);
	public Employee getEmployee(int empId);
	public List<Employee> getEmpoyeeRecords();
	
	public int[] batchEmployeeInsert(List<Employee> emps);
}
	