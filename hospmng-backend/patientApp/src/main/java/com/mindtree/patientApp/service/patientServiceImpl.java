package com.mindtree.patientApp.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.patientApp.Exception.PatientNotFoundException;
import com.mindtree.patientApp.entity.Patient;
import com.mindtree.patientApp.repository.PatientRepository;
import com.mindtree.patientApp.vo.Doctor;
import com.mindtree.patientApp.vo.ResponseTemplate;
@Component
public class patientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}
	@Override
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}
	@Override
	public Patient getPatient(Long patientId) throws PatientNotFoundException {
		Optional<Patient> patient = patientRepository.findById(patientId);
		if(patient.isPresent()) {
			return patient.get();
		}else {
			throw new PatientNotFoundException("Patient name not found in the database with id "+patientId);
		}
		
	}
	@Override
	public String deletePatient(Long patientId) throws PatientNotFoundException  {
		Optional<Patient> patient = patientRepository.findById(patientId);
		if(patient.isPresent()) {
			patientRepository.deleteById(patientId);
			return "Patient data deleted Successfully";
		}else {
			throw new PatientNotFoundException("Patient name not found in the database");
		}
	}
	@Override
	public Patient updatePatient(long patientId,Patient patient) throws PatientNotFoundException {
		Patient pat = patientRepository.findById(patientId).get();
		if(pat!=null) {
			if(patient.getName()!=null && patient.getName()!="") {
				pat.setName(patient.getName());
			}
			if(patient.getDateOfVisit()!=null && patient.getDateOfVisit()!="") {
				pat.setDateOfVisit(patient.getDateOfVisit());
			}if(patient.getVisitedDoctor()!=null && patient.getVisitedDoctor()!="") {
				pat.setVisitedDoctor(patient.getVisitedDoctor());
			}
			Patient updatedPat= patientRepository.save(pat);
			return updatedPat;	
		}
		throw new PatientNotFoundException("Patient name not found in the database");
		
	}
	@Override
	public ResponseTemplate getPatientWithDoctor(long patientId) throws PatientNotFoundException {
		ResponseTemplate vo = new ResponseTemplate();
		Optional<Patient> patient =  patientRepository.findById(patientId);
		if(patient.isPresent()) {
			Doctor doctor = restTemplate.getForObject("http://DOCTOR-SERVICE/doctors/name/"+patient.get().getVisitedDoctor(),Doctor.class);
			System.out.println(doctor);
			vo.setPatient(patient.get());
			vo.setDoctor(doctor);
			return vo;
		}
		 throw new PatientNotFoundException("No patient found with id "+ patientId);
	}

}
