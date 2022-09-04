package com.mindtree.patientApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long PatientId;
	private String name;
	private String visitedDoctor;
	private String dateOfVisit;
	private String prescription="Take paracitomal 3 times a day after food";
	public Patient(Long patientId, String name, String visitedDoctor, String dateOfVisit, String prescription) {
		super();
		PatientId = patientId;
		this.name = name;
		this.visitedDoctor = visitedDoctor;
		this.dateOfVisit = dateOfVisit;
		this.prescription = prescription;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public Long getPatientId() {
		return PatientId;
	}
	public void setPatientId(Long patientId) {
		PatientId = patientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVisitedDoctor() {
		return visitedDoctor;
	}
	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}
	public String getDateOfVisit() {
		return dateOfVisit;
	}
	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	@Override
	public String toString() {
		return "Patient [PatientId=" + PatientId + ", name=" + name + ", visitedDoctor=" + visitedDoctor
				+ ", dateOfVisit=" + dateOfVisit + "]";
	}
	
	
}
