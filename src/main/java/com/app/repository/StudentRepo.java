package com.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.app.entity.Student;

//@Repository
public class StudentRepo {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class StudentRowMapper implements RowMapper<Student> {
		
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student  = new Student();
			student.setSno(rs.getLong("sno"));
			student.setSname(rs.getString("sname"));
			return student;
		}
	}
	
	public int create(Student student) {
		
		int id = jdbcTemplate.update("insert into student(sno, sname) values (?,?)",
				new Object[] {
						student.getSno(), student.getSname()
				});
		
		return id;
	}
	
	public List<Student> getAllStudents() {
		List<Student> students = jdbcTemplate.query("Select * from student", new StudentRowMapper()); 
		return students;
	}
	
	
	
}
