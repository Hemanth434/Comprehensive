package com.mindtree.DocterService.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mindtree.DocterService.Exception.DoctorNotFoundException;
import com.mindtree.DocterService.entity.Doctor;


@Component
public interface DoctorService {

	String savePatient = null;

	public List<Doctor> getAllDoctors();

	public Doctor saveDoctor(Doctor doctor);

	public Doctor getDoctor(Long Id) throws DoctorNotFoundException;

	public String deleteDoctor(Long Id) throws DoctorNotFoundException;

	public Doctor updateDoctor(long Id,Doctor doctor) throws DoctorNotFoundException;

	public Doctor findByNameIgnoreCase(String name) throws DoctorNotFoundException;

}
