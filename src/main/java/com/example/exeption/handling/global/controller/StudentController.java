package com.example.exeption.handling.global.controller;

import java.util.List;

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

import com.example.exeption.handling.global.model.Student;
import com.example.exeption.handling.global.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
		return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id){
		return  ResponseEntity.ok(studentService.getStudentById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(){
		return ResponseEntity.ok(studentService.getStudents());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer id, @RequestBody Student studentDetails){
		return ResponseEntity.ok(studentService.updateStudent(id, studentDetails));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") Integer id){
		studentService.deleteStudent(id);
		return ResponseEntity.noContent().build();
	}
	
	
	

}
