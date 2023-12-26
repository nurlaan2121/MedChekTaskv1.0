package main.models.patcient;

import main.models.Patcient;

import java.util.LinkedList;
import java.util.Map;

public interface PatcientService {
    String addPatientsToHospital(Long id,LinkedList<Patcient> patients);
    String myadd(Long id,LinkedList<Patcient> patients);
    Patcient getPatientById(Long id);
    Map<Integer, LinkedList<Patcient>> getPatientByAge();
    LinkedList<Patcient> sortPatientsByAge(String ascOrDesc);
}
