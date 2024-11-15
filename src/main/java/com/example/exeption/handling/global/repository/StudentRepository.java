package com.example.exeption.handling.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.exeption.handling.global.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	

}
