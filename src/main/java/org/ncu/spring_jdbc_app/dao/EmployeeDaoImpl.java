package org.ncu.spring_jdbc_app.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.ncu.spring_jdbc_app.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//stereotype annotation sub type of @component annotation
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int insertEmployee(Employee emp) {

		// this is sending whole data in one go instead of sending data one by one
		String query = "insert into employee values(?,?,?,?)";
		Object[] arr = { emp.getEmpId(), emp.getEmpName(), emp.getEmpSalary(), emp.getEmpAddress() };
		int result = jdbcTemplate.update(query, arr);
		return result;
	}

	@Override
	public int deleteEmployee(int empId) {
//		String query = "delete from employee where empId=?";

		return 0;
	}

	@Override
	public int updateEmployee(int empId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employee> getEmpoyeeRecords() {
		String query = "select * from employee";
		return jdbcTemplate.query(query, new EmployeeRowMapper());

	}

	@Override
	public int[] batchEmployeeInsert(final List<Employee> emps) {
		String query = "insert into employee_backup values(?, ?, ?, ?)";
		
		int[] records = jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
		
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, emps.get(i).getEmpId());
				ps.setString(2, emps.get(i).getEmpName());
				ps.setDouble(3, emps.get(i).getEmpSalary());
				ps.setString(4, emps.get(i).getEmpAddress());
			}
			
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return emps.size();
			}
		});
		return records;
	}

	@Override
	public Employee getEmployee(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

}