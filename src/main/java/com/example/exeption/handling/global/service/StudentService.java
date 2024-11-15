package com.example.exeption.handling.global.service;

import java.util.List;

import com.example.exeption.handling.global.model.Student;



public interface StudentService {
	
	Student createStudent(Student student);
	
	List<Student> getStudents();
	
	Student getStudentById(Integer id);
	
	Student updateStudent(Integer id, Student student);
	
	void deleteStudent(Integer id);

}
