package com.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.app.entity.Student;

@Repository
public class StudentJDBCRepository {
	
    @Autowired
    JdbcTemplate jdbcTemplate;

    class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Student student = new Student();
        	student.setSno(rs.getLong("sno"));
        	student.setSname(rs.getString("sname"));
            return student;
        }
    }

    public List <Student> findAll() {
        return jdbcTemplate.query("select * from student", new StudentRowMapper());
    }

    public Student findById(long id) {
    	Optional<Student> studentOpt =  Optional.of(jdbcTemplate.queryForObject("select * from student where sno=?", new Object[] {
                id
            },
            new BeanPropertyRowMapper < Student > (Student.class)));
    	
    	if(studentOpt.isPresent()) {
    		return studentOpt.get();
    	}
    	return null;
    }
    
    public Student findById2(long id) {
    	Student student =  jdbcTemplate.queryForObject("select * from student where sno=?", new Object[] {
                id
            },
            new BeanPropertyRowMapper < Student > (Student.class));
   
    	return student;
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from student where sno=?", new Object[] {
            id
        });
    }

    public int insert(Student student) {
        int query_status = jdbcTemplate.update("insert into student (sno, sname) " + "values(?, ?)",
            new Object[] {
            		student.getSno(), student.getSname()
            });
        
       return query_status;
    }

    public int update(Student student) {
        return jdbcTemplate.update("update student " + " set sname = ?" + " where sno = ?",
            new Object[] {
            		student.getSno(), student.getSname()
            });
    }
}