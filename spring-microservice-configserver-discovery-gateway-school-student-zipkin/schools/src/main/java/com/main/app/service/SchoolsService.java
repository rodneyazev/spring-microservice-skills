package com.main.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.main.app.model.FullSchoolsResponse;
import com.main.app.model.Schools;
import com.main.app.model.StudentClient;
import com.main.app.repository.SchoolsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolsService {
	
	private final SchoolsRepository schoolsRepository;
	private final StudentClient studentClient;
	
	public void saveSchool(Schools student) {
		schoolsRepository.save(student);
	}
	
	public List<Schools> findAllSchools(){
		return schoolsRepository.findAll();
	}

	public FullSchoolsResponse findSchoolsWithStudents(Integer schoolId) {
		
		var school = schoolsRepository.findById(schoolId)
					.orElse(
							Schools.builder()
								.name("NOT_FOUND")
								.email("NOT FOUND")
								.build());
		
		var students = studentClient.findAllStudentsBySchool(schoolId);
		
		return FullSchoolsResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
	}

}
