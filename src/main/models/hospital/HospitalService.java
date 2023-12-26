package main.models.hospital;

import main.models.Hospital;
import main.models.Patcient;

import java.util.LinkedList;
import java.util.Map;

public interface HospitalService {
    String addHospital(Hospital hospital);
    Hospital findHospitalById(Long id);
    LinkedList<Hospital> getAllHospital();
    LinkedList<Patcient> getAllPatientFromHospital(Long id);
    String deleteHospitalById(Long id);
    Map<String, Hospital> getAllHospitalByAddress(String address);
}
