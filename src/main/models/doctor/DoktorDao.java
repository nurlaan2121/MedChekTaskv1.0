package main.models.doctor;

import main.models.Doctor;
import main.models.Hospital;
import main.models.hospital.HospitalDao;

import java.util.LinkedList;

public class DoktorDao {
    private final HospitalDao hospitalDao;

    public DoktorDao(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }
    public Boolean addDoctorToHospital(int indexhospital, LinkedList<Doctor> doctors){
        hospitalDao.getallhospitals().get(indexhospital).setDoctors(doctors);
        return true;
    }
    public LinkedList<Hospital> getallHospitals(){
        return hospitalDao.getallhospitals();
    }
    public void deleteDoctorInHospital(int indexHospital,int indexDoctor) {
        hospitalDao.getallhospitals().get(indexHospital).getDoctors().remove(indexDoctor);
    }


}
