package com.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.StudentModel;
import com.app.service.StudentService;

@RestController
@RequestMapping(value="student")
public class StudentController {
	
	static Logger logger = Logger.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value="/all")
	public ResponseEntity<Object> getAll() {
		return ResponseEntity.ok(HttpStatus.OK).ok(studentService.getAllStudents());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Object> getStudent(@PathVariable("id") Integer id) {
		return null;
	}
	
	@GetMapping(value="/v2/student/{id}")
	public ResponseEntity<List<StudentModel>> getStudent2(@PathVariable("id") Integer id, 
			@PathVariable("startsWith") String nameStartsWith) {
		return null;
	}
	
	
	@PostMapping
	public ResponseEntity<Long> post(@RequestBody StudentModel student) {
		Long sno = studentService.createStudent(student);
		return ResponseEntity.ok(HttpStatus.OK).ok(sno);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<String> put(@PathVariable("id") Integer id, @RequestBody StudentModel student) {
		return null;
	}

	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		return null;
	}
	
	

}
