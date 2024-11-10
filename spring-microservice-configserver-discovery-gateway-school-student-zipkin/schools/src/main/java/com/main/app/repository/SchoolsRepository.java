package com.main.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.app.model.Schools;

@Repository
public interface SchoolsRepository extends JpaRepository<Schools, Integer> {

}
