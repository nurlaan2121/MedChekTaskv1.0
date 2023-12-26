package main.models;

import java.util.LinkedList;
import java.util.List;

public class Hospital{
    private Long id;
    private String hospitalName;
    private String address;
    private LinkedList<Department> departments = new LinkedList<>();
    private LinkedList<Doctor> doctors = new LinkedList<>();
    private LinkedList<Patcient> patcients = new LinkedList<>();

    public Hospital() {
    }

    public Hospital(Long id, String hospitalName, String address, LinkedList<Department> departments, LinkedList<Doctor> doctors, LinkedList<Patcient> patcients) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.address = address;
        this.departments = departments;
        this.doctors = doctors;
        this.patcients = patcients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LinkedList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(LinkedList<Department> departments) {
        this.departments = departments;
    }

    public LinkedList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(LinkedList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public LinkedList<Patcient> getPatcients() {
        return patcients;
    }

    public void setPatcients(LinkedList<Patcient> patcients) {
        this.patcients = patcients;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", hospitalName='" + hospitalName + '\'' +
                ", address='" + address + '\'' +
                ", departments=" + departments +
                ", doctors=" + doctors +
                ", patcients=" + patcients +
                '}';
    }
}
