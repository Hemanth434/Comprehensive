package com.mindtree.DocterService.controller;

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

import com.mindtree.DocterService.Exception.DoctorNotFoundException;
import com.mindtree.DocterService.entity.Doctor;
import com.mindtree.DocterService.service.DoctorService;


@RestController
@RequestMapping("/doctors")
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/")
	public List<Doctor> getAllDoctors(){
		return doctorService.getAllDoctors();
	}
	@GetMapping("/name/{name}")
	public Doctor findByNameIgnoreCase(@PathVariable("name") String name) throws DoctorNotFoundException {
		return doctorService.findByNameIgnoreCase(name);
	}
	@PostMapping("/")
	public Doctor saveDoctor(@RequestBody Doctor doctor) {
		return doctorService.saveDoctor(doctor);
	}
	@GetMapping("/{id}")
	public Doctor getDoctor(@PathVariable("id") Long Id) throws DoctorNotFoundException {
		return doctorService.getDoctor(Id);
	}
	@DeleteMapping("/{id}")
	public String deleteDoctor(@PathVariable("id") Long Id)  throws DoctorNotFoundException{
		return doctorService.deleteDoctor(Id);
	}
	@PutMapping("/{id}")
	public Doctor updateDoctor(@PathVariable("id") long Id,@RequestBody Doctor doctor) throws DoctorNotFoundException  {
		return doctorService.updateDoctor(Id,doctor);
	}
}
