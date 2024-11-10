package com.main.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.main.app.model.Students;
import com.main.app.service.StudentsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentsController {
	
	private final StudentsService studentService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Students student) {
		studentService.saveStudent(student);
	}
	
	@GetMapping
	public ResponseEntity<List<Students>> findAllStudents(){
		return ResponseEntity.ok(studentService.findAllStudents());
	}
	
	@GetMapping("/schools/{school-id}")
	public ResponseEntity<List<Students>> findAllStudents(@PathVariable("school-id") Integer schoolId){
		return ResponseEntity.ok(studentService.findAllStudentsBySchool(schoolId));
	}

}
