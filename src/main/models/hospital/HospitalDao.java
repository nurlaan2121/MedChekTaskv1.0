package main.models.hospital;

import main.DataBase;
import main.models.Hospital;

import java.util.LinkedList;

public class HospitalDao {
    private final DataBase dataBase;

    public HospitalDao(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    public Boolean addHospital(Hospital hospital){
       return dataBase.add(hospital);
    }
    public LinkedList<Hospital> getallhospitals(){
        return dataBase.getHospitals();
    }
    public Boolean removeHospital(Long index){
        return dataBase.remove(index);
    }
    public void update(int index,Hospital hospital){
        dataBase.update(index,hospital);
    }
}
