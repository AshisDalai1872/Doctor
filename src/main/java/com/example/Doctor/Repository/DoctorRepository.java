package com.example.Doctor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Doctor.Entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

}
