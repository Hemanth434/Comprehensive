package com.mindtree.patientApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.mindtree.patientApp.entity.Patient;
@Repository

public interface PatientRepository extends JpaRepository<Patient,Long>{


}