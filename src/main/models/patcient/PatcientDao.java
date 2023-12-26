package main.models.patcient;

import main.models.Hospital;
import main.models.Patcient;
import main.models.hospital.HospitalDao;

import java.util.LinkedList;

public class PatcientDao {
    private final HospitalDao hospitalDao;

    public PatcientDao(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    public Boolean addPatcient(int index,LinkedList<Patcient> patcients) {
        LinkedList<Patcient> patcients1 = hospitalDao.getallhospitals().get(index).getPatcients();
        patcients1.addAll(patcients);
        hospitalDao.getallhospitals().get(index).setPatcients(patcients1);
        return true;
    }

    public LinkedList<Patcient> getPatcients() {
        LinkedList<Patcient> allpatcients = new LinkedList<>();
        for (int i = 0; i < hospitalDao.getallhospitals().size(); i++) {
            allpatcients.addAll(hospitalDao.getallhospitals().get(i).getPatcients());
        }
        return allpatcients;
    }

    public Boolean remove(long i, long j) {
        hospitalDao.getallhospitals().get((int) i).getPatcients().remove((int)j);
        return true;
    }

    public void updatePatcient(Long index, Patcient patcient) {
        for (int i = 0; i < hospitalDao.getallhospitals().size(); i++) {
            for (int j = 0; j < hospitalDao.getallhospitals().get(i).getPatcients().size(); j++) {
                if (hospitalDao.getallhospitals().get(i).getPatcients().get(j).getId().equals(index)) {
                    hospitalDao.getallhospitals().get(i).getPatcients().get(j).setFirstName(patcient.getFirstName());
                    hospitalDao.getallhospitals().get(i).getPatcients().get(j).setAge(patcient.getAge());
                    hospitalDao.getallhospitals().get(i).getPatcients().get(j).setLastName(patcient.getLastName());
                    hospitalDao.getallhospitals().get(i).getPatcients().get(j).setGender(patcient.getGender());
                }
            }
        }
        System.out.println("Success!");
    }

    public LinkedList<Hospital> allhospitals() {
        return hospitalDao.getallhospitals();
    }
}
