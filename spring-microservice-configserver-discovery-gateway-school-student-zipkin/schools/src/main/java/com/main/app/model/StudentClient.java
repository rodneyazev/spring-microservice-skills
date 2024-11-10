package com.main.app.model;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "students-service", url = "${application.config.students-url}")
public interface StudentClient {
	
	@GetMapping("/schools/{school-id}")
    List<Students> findAllStudentsBySchool(@PathVariable("school-id") Integer schoolId);

}
