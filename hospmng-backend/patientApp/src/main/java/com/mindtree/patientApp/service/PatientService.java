package com.mindtree.patientApp.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mindtree.patientApp.Exception.PatientNotFoundException;
import com.mindtree.patientApp.entity.Patient;
import com.mindtree.patientApp.vo.ResponseTemplate;


@Component
public interface PatientService {


	public List<Patient> getAllPatients();

	public Patient savePatient(Patient patient);

	public Patient getPatient(Long patientId) throws PatientNotFoundException;

	public String deletePatient(Long patientId) throws PatientNotFoundException;

	public Patient updatePatient(long patientId,Patient patient) throws PatientNotFoundException;

	public ResponseTemplate getPatientWithDoctor(long patientId) throws PatientNotFoundException;

}
