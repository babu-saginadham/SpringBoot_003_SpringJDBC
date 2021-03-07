package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Student;
import com.app.model.StudentModel;
import com.app.repository.StudentJDBCRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentJDBCRepository studentJDBCRepository;
	
	@Override
	public Long createStudent(StudentModel studentModel) {
		
		//Object mapping - converting request model to db entity model
		Student studentToSave = new Student();
		studentToSave.setSname(studentModel.getSname());
		
		studentJDBCRepository.insert(studentToSave);
		
		return 1L;
	}

	@Override
	public void updateStudent(StudentModel studentModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudent(Long sno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StudentModel> getAllStudents() {
		List<Student> studentsFromDB = studentJDBCRepository.findAll();
		
		List<StudentModel> studentModels = new ArrayList<>();
		for(Student stud:studentsFromDB) {
			StudentModel studentModel = new StudentModel();
			studentModel.setSno(stud.getSno());
			studentModel.setSname(stud.getSname());
			
			studentModels.add(studentModel);
			
		}
		
		return studentModels;
	}

	@Override
	public StudentModel getStudent(Long sno) {
		// TODO Auto-generated method stub
		return null;
	}

}
