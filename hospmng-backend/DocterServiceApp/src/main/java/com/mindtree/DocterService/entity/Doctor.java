package com.mindtree.DocterService.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long age;
	private String gender;
	private String specialization;
	private Long patientsAttended=0L;
	
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(Long id, String name, Long age, String gender, String specialization, Long patientsAttended) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.specialization = specialization;
		this.patientsAttended = patientsAttended;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
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
