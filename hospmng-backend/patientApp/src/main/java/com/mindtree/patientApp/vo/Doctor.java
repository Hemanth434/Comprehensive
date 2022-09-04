package com.mindtree.patientApp.vo;

public class Doctor {
	private Long id;
	private String name;
	private String gender;
	private String specialization;
	private Long patientsAttended;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(Long id, String name, String gender, String specialization, Long patientsAttended) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.specialization = specialization;
		this.patientsAttended = patientsAttended;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public Long getPatientsAttended() {
		return patientsAttended;
	}
	public void setPatientsAttended(Long patientsAttended) {
		this.patientsAttended = patientsAttended;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", gender=" + gender + ", specialization=" + specialization
				+ ", patientsAttended=" + patientsAttended + "]";
	}
	

}
