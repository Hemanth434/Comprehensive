package com.mindtree.patientApp.vo;

import com.mindtree.patientApp.entity.Patient;

public class ResponseTemplate {

	private Patient patient;
	private Doctor doctor;
	public ResponseTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseTemplate(Doctor doctor, Patient patient) {
		super();
		this.doctor = doctor;
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
