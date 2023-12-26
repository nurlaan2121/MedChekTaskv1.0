package main;

import main.models.Hospital;

import java.util.LinkedList;

public class DataBase {

    public LinkedList<Hospital> hospitals= new LinkedList<>();

    public Boolean add(Hospital hospital){
        return hospitals.add(hospital);
    }
    public Boolean remove(Long index){
        long num = index;
        hospitals.remove((int)num);
        return true;

    }
    public LinkedList<Hospital> getHospitals(){
        return hospitals;
    }
    public void update(int index,Hospital hospital){
        hospitals.get(index).setHospitalName(hospital.getHospitalName());
        hospitals.get(index).setAddress(hospital.getAddress());
        hospitals.get(index).setDoctors(hospital.getDoctors());
        hospitals.get(index).setPatcients(hospital.getPatcients());
        hospitals.get(index).setDepartments(hospital.getDepartments());
    }
}
