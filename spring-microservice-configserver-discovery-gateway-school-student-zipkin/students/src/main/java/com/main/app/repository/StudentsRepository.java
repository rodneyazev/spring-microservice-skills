package com.main.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.app.model.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer> {

	List<Students> findAllBySchoolId(Integer schoolId);

}
