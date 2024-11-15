package com.example.exeption.handling.global.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exeption.handling.global.exception.StudentNotFoundException;
import com.example.exeption.handling.global.model.Student;
import com.example.exeption.handling.global.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public Student createStudent(Student student) {
		
		Student s = new Student();
		s.setName(student.getName());
		s.setDob(student.getDob());
		s.setEmail(student.getEmail());
		s.setMobileNumber(student.getMobileNumber());
		
		return studentRepository.save(s);
	
	}

	
	public List<Student> getStudents() {
		return studentRepository.findAll()
				                .stream()
				                .collect(Collectors.toList());
	}

	
	public Student getStudentById(Integer id) {
		Student student = studentRepository.findById(id)
		                 .orElseThrow(()-> new StudentNotFoundException("Student not found with id "+id));
		return student;
	}

	
	public Student updateStudent(Integer id, Student studentDetail) {
		
		Student student = studentRepository.findById(id)
              .orElseThrow(()-> new StudentNotFoundException("Student not found with id "+id));
		         student.setId(studentDetail.getId());
		         student.setName(studentDetail.getName());
		         student.setDob(studentDetail.getDob());
		         student.setEmail(studentDetail.getEmail());
		         student.setMobileNumber(studentDetail.getMobileNumber());
		return studentRepository.save(student);
	}

	
	public void deleteStudent(Integer id) {
		Student student2 = studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException("Student not found with id "+id));
		studentRepository.delete(student2);
		
	}
	
	

}
