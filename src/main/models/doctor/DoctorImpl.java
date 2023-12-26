package main.models.doctor;

import main.models.*;
import main.myExceptions.Notfound;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class DoctorImpl implements DoctorService, GenericService<Doctor> {
    private final DoktorDao doktorDao;
    public Long id = 0L;

    public DoctorImpl(DoktorDao doktorDao) {
        this.doktorDao = doktorDao;
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        for (int i = 0; i < doktorDao.getallHospitals().size(); i++) {
            if (hospitalId.equals(doktorDao.getallHospitals().get(i).getId())) {
                while (true) {
                    System.out.println("Write first name doctor: ");
                    String name = new Scanner(System.in).nextLine();
                    if (GenericChecks.chekone(name)) {
                        doctor.setFirstName(name.trim());
                        doctor.setId(++id);
                        break;
                    }
                }
                while (true) {
                    System.out.println("Write last name doctor: ");
                    String name = new Scanner(System.in).nextLine();
                    if (GenericChecks.chekone(name)) {
                        doctor.setLastName(name.trim());
                        break;
                    }
                }
                while (true) {
                    System.out.println("Write gender doctor: ");
                    String name = new Scanner(System.in).nextLine();
                    if (name.equalsIgnoreCase(Gender.MALE.name())) {
                        doctor.setGender(Gender.MALE);
                        break;
                    } else if (name.equalsIgnoreCase(Gender.FEMALE.name())) {
                        doctor.setGender(Gender.FEMALE);
                        break;
                    }
                }
                while (true) {
                    System.out.println("Write experience year: ");
                    try {
                        int name = new Scanner(System.in).nextInt();
                        if (name > 1) {
                            doctor.setExperienceYear(name);
                            break;
                        }
                    } catch (InputMismatchException exception) {
                        System.out.println("Write year:");
                        new Scanner(System.in).close();
                    }
                }
                LinkedList<Doctor> doctors = doktorDao.getallHospitals().get(i).getDoctors();
                doctors.add(doctor);
                doktorDao.addDoctorToHospital(i, doctors);
                return "Success!";
            }
        }

        throw new Notfound("Not faunt!");
    }

    @Override
    public void removeById(Long id) {
        for (int i = 0; i < doktorDao.getallHospitals().size(); i++) {
            for (int j = 0; j < doktorDao.getallHospitals().get(i).getDoctors().size(); j++) {
                if (id.equals(doktorDao.getallHospitals().get(i).getDoctors().get(j).getId())) {
                    doktorDao.deleteDoctorInHospital(i, j);
                    for (int k = 0; k < doktorDao.getallHospitals().size(); k++) {
                        for (int i1 = 0; i1 < doktorDao.getallHospitals().get(i).getDepartments().size(); i1++) {
                            for (int i2 = 0; i2 < doktorDao.getallHospitals().get(k).getDepartments().get(i1).getDoctors().size(); i2++) {
                                if (doktorDao.getallHospitals().get(k).getDepartments().get(i1).getDoctors().get(i2).getId().equals(id)){
                                    doktorDao.getallHospitals().get(k).getDepartments().get(i1).getDoctors().remove(i2);
                                    break;
                                }
                            }
                        }
                    }
                    System.out.println("Success!");
                }
            }
        }
    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        for (int i = 0; i < doktorDao.getallHospitals().size(); i++) {
            for (int j = 0; j < doktorDao.getallHospitals().get(i).getDoctors().size(); j++) {
                if (id.equals(doktorDao.getallHospitals().get(i).getDoctors().get(j).getId())) {
                    System.out.println("""
                            Choose command for update: 
                            1.First name
                            2.Last name
                            3.Gender
                            4.Exception year
                                            
                            """);
                    try {
                        int num = new Scanner(System.in).nextInt();
                        switch (num) {
                            case 1 -> {
                                while (true) {
                                    System.out.println("Write first name doctor: ");
                                    String name = new Scanner(System.in).nextLine();
                                    if (GenericChecks.chekone(name)) {
                                        doctor.setFirstName(name.trim());
                                        doktorDao.getallHospitals().get(i).getDoctors().get(j).setFirstName(doctor.getFirstName());
                                        break;
                                    }
                                }
                            }
                            case 2 -> {
                                while (true) {
                                    System.out.println("Write last name doctor: ");
                                    String name = new Scanner(System.in).nextLine();
                                    if (GenericChecks.chekone(name)) {
                                        doctor.setLastName(name.trim());
                                        doktorDao.getallHospitals().get(i).getDoctors().get(j).setLastName(doctor.getLastName());
                                        break;
                                    }
                                }

                            }
                            case 3 -> {
                                while (true) {
                                    System.out.println("Write gender doctor: ");
                                    String name = new Scanner(System.in).nextLine();
                                    if (name.equalsIgnoreCase(Gender.MALE.name())) {
                                        doctor.setGender(Gender.MALE);
                                        doktorDao.getallHospitals().get(i).getDoctors().get(j).setGender(doctor.getGender());
                                        break;
                                    } else if (name.equalsIgnoreCase(Gender.FEMALE.name())) {
                                        doctor.setGender(Gender.FEMALE);
                                        doktorDao.getallHospitals().get(i).getDoctors().get(j).setGender(doctor.getGender());
                                        break;
                                    }
                                }

                            }
                            case 4 -> {
                                while (true) {
                                    System.out.println("Write experience year: ");
                                    try {
                                        int name = new Scanner(System.in).nextInt();
                                        if (name > 1) {
                                            doctor.setExperienceYear(name);
                                            doktorDao.getallHospitals().get(i).getDoctors().get(j).setExperienceYear(doctor.getExperienceYear());
                                            break;
                                        }
                                    } catch (InputMismatchException exception) {
                                        System.out.println("Write year:");
                                        new Scanner(System.in).close();
                                    }
                                }
                            }

                        }
                        return "Succes";

                    } catch (InputMismatchException exception) {
                        System.out.println("San jaz!");

                    }
                }
            }
        }throw new Notfound("Not faunt!");

    }


    @Override
    public Doctor findDoctorById(Long id) {
        for (Hospital hospital : doktorDao.getallHospitals()) {
            for (Doctor doctor : hospital.getDoctors()) {
                if (id.equals(doctor.getId())) {
                    return doctor;
                }
            }
        }
        throw new Notfound("Not faunt!");
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, LinkedList<Long> doctorsId) {
        int amount = 0;
        LinkedList<Doctor> doctors = new LinkedList<>();
        for (int i = 0; i < doktorDao.getallHospitals().size(); i++) {
            for (int i1 = 0; i1 < doktorDao.getallHospitals().get(i).getDoctors().size(); i1++) {
                if (doctorsId.contains(doktorDao.getallHospitals().get(i).getDoctors().get(i1).getId())){
                    amount++;
                    doctors.add(doktorDao.getallHospitals().get(i).getDoctors().get(i1));
                }
            }
        }
        if (amount == doctorsId.size()){
            for (int i = 0; i < doktorDao.getallHospitals().size(); i++) {
                for (int i1 = 0; i1 < doktorDao.getallHospitals().get(i).getDepartments().size(); i1++) {
                    if (departmentId.equals(doktorDao.getallHospitals().get(i).getDepartments().get(i1).getId())){
                        LinkedList<Doctor> doctors1 = doktorDao.getallHospitals().get(i).getDepartments().get(i1).getDoctors();
                        doctors1.addAll(doctors);
                        doktorDao.getallHospitals().get(i).getDepartments().get(i1).setDoctors(doctors1);
                        return "Success!";
                    }
                }
            }
        }
        throw new Notfound("Not faunt!");
    }

    @Override
    public LinkedList<Doctor> getAllDoctorsByHospitalId(Long id) {
        for (int i = 0; i < doktorDao.getallHospitals().size(); i++) {
            if (id.equals(doktorDao.getallHospitals().get(i).getId())){
                return doktorDao.getallHospitals().get(i).getDoctors();
            }
        }
        throw new Notfound("Not faunt!");
    }

    @Override
    public LinkedList<Doctor> getAllDoctorsByDepartmentId(Long id) {
        for (int i = 0; i < doktorDao.getallHospitals().size(); i++) {
            for (int i1 = 0; i1 < doktorDao.getallHospitals().get(i).getDepartments().size(); i1++) {
                if (id.equals(doktorDao.getallHospitals().get(i).getDepartments().get(i1).getId())){
                    return doktorDao.getallHospitals().get(i).getDepartments().get(i1).getDoctors();
                }
            }
        }
        throw new Notfound("Not faunt!");

    }
}
