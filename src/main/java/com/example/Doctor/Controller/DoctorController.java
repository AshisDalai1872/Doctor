package com.example.Doctor.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Doctor.Entity.Doctor;
import com.example.Doctor.Exception.DoctorException;
import com.example.Doctor.Service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@GetMapping("/Home")
	public String Home() {
		
		return "welcome to Doctorhomepage ";
	}
	
	@Autowired
	private DoctorService doctorSerivice;
	
	
	@GetMapping("/getdoctor/{id}") //get doctro by id
	public ResponseEntity<Doctor> getDoctor(@PathVariable Long id) throws DoctorException 
	{
	Doctor doctor=	doctorSerivice.getById(id);
	if(doctor!=null) {
		return new ResponseEntity<>(doctor,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	@GetMapping("/getALldoctors") //get all doctors form db
	public ResponseEntity<List<Doctor>> getAllDoctor()
	{
		
		List<Doctor> listDoctor=doctorSerivice.getAllDoctors();
		return new ResponseEntity<>(listDoctor,HttpStatus.OK);
		
	}
	@PostMapping("/addDoctor") // create / addd new doctors
	public ResponseEntity<Doctor> addNewDoctor(@RequestBody Doctor doctor)
	{
		Doctor doctor1= doctorSerivice.createDoctor(doctor);
		return new ResponseEntity<>(doctor1,HttpStatus.CREATED);		
		
	}
	@PostMapping("/addDoctors") // create or add multiple doctor
	public ResponseEntity<List<Doctor>> addDoctors(@RequestBody List<Doctor> doctors)
	{
		
	List<Doctor>  list=doctorSerivice.createDoctors(doctors);
	return new ResponseEntity<>(list,HttpStatus.CREATED);
		
	}
	@DeleteMapping("/deleteDoctor/{id}")
	public ResponseEntity<String>  deleteDoctorByid(@PathVariable Long id) {
		
		doctorSerivice.deleteDoctorById(id);
		return new ResponseEntity<>("succesfully deleted",HttpStatus.NO_CONTENT);
		
	}
	@DeleteMapping("/deleteAll")
	public String deleteAllDoctors()
	{
		doctorSerivice.deleteAllDoctor();
		return "all doctors deleted";
		
	}
}
