package com.mindtree.patientApp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mindtree.patientApp.Exception.PatientNotFoundException;
import com.mindtree.patientApp.entity.Patient;
import com.mindtree.patientApp.service.PatientService;
import com.mindtree.patientApp.vo.ResponseTemplate;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	
	@GetMapping("/")
	public List<Patient> getAllPatients(){
		System.out.println("i am from patient service");
		return patientService.getAllPatients();
	}
	@PostMapping("/")
	public Patient savePatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}
	@GetMapping("/{id}")
	public Patient getPatient(@PathVariable("id") Long PatientId) throws PatientNotFoundException {
		return patientService.getPatient(PatientId);
	}
	@DeleteMapping("/{id}")
	public String deletePatient(@PathVariable("id") Long PatientId)  throws PatientNotFoundException{
		return patientService.deletePatient(PatientId);
	}
	@PutMapping("/{id}")
	public Patient updatePatient(@PathVariable("id") long PatientId,@RequestBody Patient patient) throws PatientNotFoundException  {
		return patientService.updatePatient(PatientId,patient);
	}
	
	@GetMapping("/patientwithdoctor/{id}")
	public ResponseTemplate getPatientWithDoctor(@PathVariable("id") long PatientId) throws PatientNotFoundException  {
		return patientService.getPatientWithDoctor(PatientId);
	}
}
