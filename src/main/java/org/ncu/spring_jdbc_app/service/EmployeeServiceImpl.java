package org.ncu.spring_jdbc_app.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.ncu.spring_jdbc_app.dao.EmployeeDao;
import org.ncu.spring_jdbc_app.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//sub type of @component annotation it is a stereotype 
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao empDao;

	public String createRecord(Employee emp) {
		int result = empDao.insertEmployee(emp);
		if (result == 0) {
			return "Error Saving Record.";
		} 
		else {
			return "Record Inserted Successfully";
		}
	}

	public int updateRecord(int empId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteRecord(int empId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Employee fetchEmployee(int empId) {
		// TODO Auto-generated method stub
		return null;
	}
	

	public List<Employee> loadEmployees() {
		// TODO Auto-generated method stub
		List<Employee> emp = empDao.getEmpoyeeRecords();
		if (emp != null) {
			return emp;
		} else {
			return null;
		}
	}
	
	public void batchInsertRecord(List<Employee> emps) {
		int[] records = empDao.batchEmployeeInsert(emps);
		if(records != null) {
			System.out.println("Batch operation success!!");
		}else {
			System.out.println("Error inserting batch records!!");
		}
		
	}

	class sortbysalarya implements Comparator<Employee>{
		public int compare(Employee a,Employee b) {
			return  (int) (a.getEmpSalary() - b.getEmpSalary());
  		}
	}
	class sortbysalaryd implements Comparator<Employee>{
		public int compare(Employee a,Employee b) {
			return  (int) (b.getEmpSalary() - a.getEmpSalary());
  		}
	}
	@Override
	public List<Employee> Sortbysalarya() {
		List<Employee> emp = empDao.getEmpoyeeRecords();
		Collections.sort(emp,new sortbysalarya());
		return emp;
	}
	

	@Override
	public List<Employee> Sortbysalaryd() {
		List<Employee> emp = empDao.getEmpoyeeRecords();
		Collections.sort(emp,new sortbysalaryd());
		return null;
	}
	
	
	

}