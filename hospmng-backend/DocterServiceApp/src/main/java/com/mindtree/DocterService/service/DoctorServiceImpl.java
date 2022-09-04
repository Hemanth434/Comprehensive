package com.mindtree.DocterService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindtree.DocterService.Exception.DoctorNotFoundException;
import com.mindtree.DocterService.entity.Doctor;
import com.mindtree.DocterService.repository.DoctorRepository;
@Component
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}
	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	@Override
	public Doctor getDoctor(Long Id) throws DoctorNotFoundException {
		Optional<Doctor> doctor = doctorRepository.findById(Id);
		if(doctor.isPresent()) {
			return doctor.get();
		}else {
			throw new DoctorNotFoundException("Doctor name not found in the database");
		}
		
	}
	@Override
	public String deleteDoctor(Long Id) throws DoctorNotFoundException  {
		Optional<Doctor> doctor = doctorRepository.findById(Id);
		if(doctor.isPresent()) {
			doctorRepository.deleteById(Id);
			return "Patient data deleted Successfully";
		}else {
			throw new DoctorNotFoundException("Doctor name not found in the database");
		}
	}
	@Override
	public Doctor updateDoctor(long Id,Doctor doctor) throws DoctorNotFoundException {
		Doctor doc = doctorRepository.findById(Id).get();
		if(doc!=null) {
			if(doctor.getName()!=null && doctor.getName()!="") {
				doc.setName(doctor.getName());
			}
			if(doctor.getGender()!=null && doctor.getGender()!="") {
				doc.setGender(doctor.getGender());
			}if(doctor.getPatientsAttended()!=null && doctor.getPatientsAttended()!=0) {
				doc.setPatientsAttended(doctor.getPatientsAttended());
			}
			Doctor updatedPat= doctorRepository.save(doc);
			return updatedPat;	
		}
		throw new DoctorNotFoundException("Doctor name not found in the database");
		
	}
	@Override
	public Doctor findByNameIgnoreCase(String name) throws DoctorNotFoundException {
		Doctor doc = doctorRepository.findByNameIgnoreCase(name);
		if(doc==null) {
			throw new DoctorNotFoundException("OOps!! No doctor found with "+name+" in the database");
		}else {
			return doc;
		}
	}

}
