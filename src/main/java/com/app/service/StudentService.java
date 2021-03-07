package com.app.service;

import java.util.List;

import com.app.model.StudentModel;

public interface StudentService {

	public Long createStudent(StudentModel studentModel);
	
	public void updateStudent(StudentModel studentModel);
	
	public void deleteStudent(Long sno);
	
	public List<StudentModel> getAllStudents();
	
	public StudentModel getStudent(Long sno);
	
	
}
