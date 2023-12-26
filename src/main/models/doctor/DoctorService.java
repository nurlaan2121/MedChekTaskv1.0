package main.models.doctor;

import main.models.Doctor;

import java.util.LinkedList;

public interface DoctorService {
    Doctor findDoctorById(Long id);
    String assignDoctorToDepartment(Long departmentId, LinkedList<Long> doctorsId);
    LinkedList<Doctor> getAllDoctorsByHospitalId(Long id);
    LinkedList<Doctor> getAllDoctorsByDepartmentId(Long id);
}
