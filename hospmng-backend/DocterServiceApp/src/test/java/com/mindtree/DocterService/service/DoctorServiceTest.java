package com.mindtree.DocterService.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mindtree.DocterService.Exception.DoctorNotFoundException;
import com.mindtree.DocterService.controller.DoctorController;
import com.mindtree.DocterService.entity.Doctor;
import com.mindtree.DocterService.repository.DoctorRepository;

@SpringBootTest
class DoctorServiceTest {


	@Autowired
	private DoctorController doctorController = mock(DoctorController.class);
	@Autowired
	private DoctorService doctorService;
	
	@MockBean
	private DoctorRepository doctorRepository;
	
	
	@Test
	public void getAllDetails() throws Exception {
		when(doctorController.getAllDoctors()).thenReturn(Stream.of(new Doctor(1L,"Tarun",23L,"Male","Cardio",0L), 
						new Doctor(2L,"mukesh",24L,"Male","Orthology",2L))
				.collect(Collectors.toList()));
		Assertions.assertFalse(doctorService.getAllDoctors().isEmpty());
		assertEquals(2, doctorService.getAllDoctors().size());
	}

	@Test
	void testGetDoctorById() throws DoctorNotFoundException {
		Long id = 1L;
		Optional<Doctor> doctor =Optional.ofNullable(new Doctor(1L,"Tarun",23L,"Male","Cardio",0L));
		when(doctorRepository.findById(id)).thenReturn(doctor);
		assertEquals(doctor, doctorRepository.findById(id));
	}

}
