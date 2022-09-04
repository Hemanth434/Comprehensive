package com.mindtree.DocterService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.mindtree.DocterService.entity.Doctor;
@Repository

public interface DoctorRepository extends JpaRepository<Doctor,Long>{

	public Doctor findByNameIgnoreCase(String name);


}
