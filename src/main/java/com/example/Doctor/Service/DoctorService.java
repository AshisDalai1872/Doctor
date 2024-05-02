package com.example.Doctor.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Doctor.Entity.Doctor;
import com.example.Doctor.Exception.DoctorException;
import com.example.Doctor.Repository.DoctorRepository;

import jakarta.persistence.GeneratedValue;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	
	public Doctor createDoctor(Doctor doctor)
	{
		Doctor doctor1=doctorRepository.save(doctor);
		return doctor1;
		
	}
	public List<Doctor> createDoctors(List<Doctor> doctors)
	{
		
		return doctorRepository.saveAll(doctors);
		
	}
	
	public Doctor getById(Long id) throws DoctorException
	{
		return doctorRepository.findById(id).orElseThrow(()->new DoctorException("Doctor  with ID=" +id+" record not found"));
		
		
	}
	public List<Doctor> getAllDoctors() {
		
		List<Doctor> doctorList= doctorRepository.findAll();
		
		
			return doctorList;
		
	}
	public void deleteDoctorById(Long id)
	{
		doctorRepository.deleteById(id);
		
	}
	public void deleteAllDoctor()
	{
		
		doctorRepository.deleteAll();
		
	}
 public Doctor updateByame(Long id,String newName)
 {
	Doctor doctor1= doctorRepository.findById(id).orElseThrow();
	doctor1.setDoctor_name(newName);
	
	return doctor1; 
	 
	 
 }
 public Doctor updateByAddress(Long id,String Address)
 {
	 
	 Doctor doctor2=doctorRepository.findById(id).orElseThrow();
	 doctor2.setDoctor_address(Address);
	 
	 
	 return doctor2;
	 
	 
 }
 
	
	
}
