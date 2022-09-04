package com.mindtree.patientApp;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mindtree.patientApp.controller.PatientController;
import com.mindtree.patientApp.entity.Patient;
import com.mindtree.patientApp.repository.PatientRepository;
import com.mindtree.patientApp.service.PatientService;

@SpringBootTest
class PatientAppApplicationTests {
	@Autowired
	private PatientController patientController = mock(PatientController.class);
	
	@MockBean
	private PatientRepository patientRepo;
	
	@Autowired
	private PatientService patientService;
	
	@Test
	public void addPatient() throws Exception {

//		PatientId = patientId;
//		this.name = name;
//		this.visitedDoctor = visitedDoctor;
//		this.dateOfVisit = dateOfVisit;
//		this.prescription = prescription;
		Patient patient = new Patient(1l,"hebiscus","Hemanth","20/11/2022","warf-5mg");
		
		when(patientController.savePatient(patient)).thenReturn(patient);
		assertThat(patient.getPatientId()).isGreaterThan(0);
		
//		assertThat is used to check condition (boolean)
		assertEquals(patientService.savePatient(patient),patientController.savePatient(patient));
	}
	
	
	@Test
	public void getpatientByIdTest() {
		long id = 1;
		Optional<Patient> patient = Optional.ofNullable(new Patient(1l,"hebiscus","Hemanth","20/11/2022","warf-5mg"));
		when(patientRepo.findById(id)).thenReturn(patient);
		assertEquals(patient, patientRepo.findById(id));
	}

}
