package main.models.hospital;

import main.models.GenericChecks;
import main.models.Hospital;
import main.models.Patcient;
import main.myExceptions.Notfound;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class HospitalImp implements HospitalService {

    private final HospitalDao hospitalDao;
    public long id = 0;

    public HospitalImp(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @Override
    public String addHospital(Hospital hospital) {
        while (true){
            System.out.println("Write name: ");
            String name = new Scanner(System.in).nextLine();
            if (GenericChecks.chekone(name.trim())){
                hospital.setHospitalName(name.trim());
                break;
            }
        }while (true){
            System.out.println("Write adress: ");
            String name = new Scanner(System.in).nextLine();
            if (GenericChecks.chekone(name.trim())){
                hospital.setAddress(name.trim());
                break;
            }
        }hospital.setId(++id);
        hospitalDao.addHospital(hospital);
        return "Success! saved";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        for (int i = 0; i < hospitalDao.getallhospitals().size(); i++) {
            if (id.equals(hospitalDao.getallhospitals().get(i).getId())) {
                return hospitalDao.getallhospitals().get(i);
            }
        }
        throw new Notfound("Not found");
    }

    @Override
    public LinkedList<Hospital> getAllHospital() {
        return hospitalDao.getallhospitals();
    }

    @Override
    public LinkedList<Patcient> getAllPatientFromHospital(Long id) {
        for (int i = 0; i < hospitalDao.getallhospitals().size(); i++) {
            if (id.equals(hospitalDao.getallhospitals().get(i).getId())){
                return hospitalDao.getallhospitals().get(i).getPatcients();
            }
        }throw new Notfound("Not found");
    }

    @Override
    public String deleteHospitalById(Long id) {
        for (int i = 0; i < hospitalDao.getallhospitals().size(); i++) {
            if (id.equals(hospitalDao.getallhospitals().get(i).getId())){
                hospitalDao.removeHospital((long) i);
                return "Success deleted";
            }
        }throw new Notfound("Not found");

    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String,Hospital> yes = new HashMap<>();
        for (int i = 0; i < hospitalDao.getallhospitals().size(); i++) {
            if (address.equalsIgnoreCase(hospitalDao.getallhospitals().get(i).getAddress())){
                yes.put(address,hospitalDao.getallhospitals().get(i));
                return yes;
            }
        }throw new Notfound("Not found");
    }
}
