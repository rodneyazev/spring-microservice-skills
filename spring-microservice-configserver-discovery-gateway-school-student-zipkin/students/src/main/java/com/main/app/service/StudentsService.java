package com.main.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.main.app.model.Students;
import com.main.app.repository.StudentsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentsService {
	
	private final StudentsRepository studentRepository;
	
	public void saveStudent(Students student) {
		studentRepository.save(student);
	}
	
	public List<Students> findAllStudents(){
		return studentRepository.findAll();
	}

	public List<Students> findAllStudentsBySchool(Integer schoolId) {
		// TODO Auto-generated method stub
		return studentRepository.findAllBySchoolId(schoolId);
	}

}
