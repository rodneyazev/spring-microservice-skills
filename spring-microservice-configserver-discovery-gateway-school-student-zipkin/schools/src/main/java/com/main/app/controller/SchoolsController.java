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

import com.main.app.model.FullSchoolsResponse;
import com.main.app.model.Schools;
import com.main.app.service.SchoolsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolsController {
	
	private final SchoolsService schoolsService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Schools student) {
		schoolsService.saveSchool(student);
	}
	
	@GetMapping
	public ResponseEntity<List<Schools>> findAllSchools(){
		return ResponseEntity.ok(schoolsService.findAllSchools());
	}
	
	@GetMapping("/with-students/{school-id}")
	public ResponseEntity<FullSchoolsResponse> findAllSchools(@PathVariable("school-id") Integer schoolId){
		return ResponseEntity.ok(schoolsService.findSchoolsWithStudents(schoolId));
	}

}
