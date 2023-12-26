package main.models.department;

import main.models.Department;
import main.models.Hospital;
import main.models.hospital.HospitalDao;

import java.util.LinkedList;

public class DepartmentDao {
    private final HospitalDao hospitalDao;

    public DepartmentDao(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    public boolean addDepartmentToHospitla(int indexHospital, LinkedList<Department> departments) {
        hospitalDao.getallhospitals().get(indexHospital).setDepartments(departments);
        return true;
    }

    public LinkedList<Hospital> getallHostipals() {
        return hospitalDao.getallhospitals();
    }
}
