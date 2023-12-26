package main.models.patcient;

import main.models.Gender;
import main.models.GenericChecks;
import main.models.GenericService;
import main.models.Patcient;
import main.models.hospital.HospitalDao;
import main.myExceptions.Notfound;

import java.util.*;

public class PatcientImpl implements PatcientService, GenericService<Patcient> {
    private final PatcientDao patcientDao;
    public static long id = 0;

    public PatcientImpl(PatcientDao patcientDao, HospitalDao hospitalDao) {
        this.patcientDao = patcientDao;
    }

    @Override
    public String add(Long hospitalId, Patcient patcient) {
        for (int i = 0; i < patcientDao.allhospitals().size(); i++) {
            if (hospitalId.equals(patcientDao.allhospitals().get(i).getId())) {
                while (true) {
                    System.out.println("Write first name: ");
                    String name = new Scanner(System.in).nextLine();
                    if (GenericChecks.chekone(name.trim())) {
                        patcient.setFirstName(name);
                        break;
                    }
                }
                while (true) {
                    System.out.println("Write last name: ");
                    String name = new Scanner(System.in).nextLine();
                    if (GenericChecks.chekone(name.trim())) {
                        patcient.setLastName(name);
                        break;
                    }
                }
                while (true) {
                    System.out.println("Write age : ");
                    try {
                        int name = new Scanner(System.in).nextInt();
                        if (name > 0) {
                            patcient.setAge(name);
                            break;
                        }
                    } catch (InputMismatchException exception) {
                        System.out.println("Write age please!");

                    }
                }
                while (true) {
                    System.out.println("Write gender (M||F): ");
                    String name = new Scanner(System.in).nextLine();
                    if (name.equalsIgnoreCase(Gender.MALE.name())) {
                        patcient.setGender(Gender.MALE);
                        break;
                    } else if (name.equalsIgnoreCase(Gender.FEMALE.name())) {
                        patcient.setGender(Gender.FEMALE);
                        break;
                    }
                }
                patcient.setId(++id);
                LinkedList<Patcient> patcients = new LinkedList<>();
                patcients.add(patcient);
                patcientDao.addPatcient(i, patcients);
                return "Success";
            }
        }
        throw new Notfound("Not found");
    }

    @Override
    public void removeById(Long id) {
        boolean found = true;
        for (int i = 0; i < patcientDao.allhospitals().size(); i++) {
            for (int j = 0; j < patcientDao.allhospitals().get(i).getPatcients().size(); j++) {
                if (id.equals(patcientDao.allhospitals().get(i).getPatcients().get(j).getId())) {
                    patcientDao.remove(i, j);
                    found = false;
                }
            }
        }
        if (found) {
            throw new Notfound("Not found");
        }

    }

    @Override
    public String updateById(Long id, Patcient patcient) {
        for (int i = 0; i < patcientDao.allhospitals().size(); i++) {
            for (int j = 0; j < patcientDao.allhospitals().get(i).getPatcients().size(); j++) {
                if (id.equals(patcientDao.allhospitals().get(i).getPatcients().get(j).getId())) {
                    System.out.println("""
                            Choose command for ubdate :
                            1.First name
                            2.Last name
                            3.Age
                            4.Gender
                            """);
                    try {
                        int num = new Scanner(System.in).nextInt();
                        switch (num) {
                            case 1 -> {
                                while (true) {
                                    System.out.println("Write first name: ");
                                    String name = new Scanner(System.in).nextLine();
                                    if (GenericChecks.chekone(name.trim())) {
                                        patcient.setGender(patcientDao.allhospitals().get(i).getPatcients().get(j).getGender());
                                        patcient.setAge(patcientDao.allhospitals().get(i).getPatcients().get(j).getAge());
                                        patcient.setLastName(patcientDao.allhospitals().get(i).getPatcients().get(j).getLastName());
                                        patcient.setFirstName(name);
                                        patcientDao.updatePatcient(id, patcient);
                                        break;
                                    }
                                }
                            }
                            case 2 -> {
                                while (true) {
                                    System.out.println("Write last name: ");
                                    String name = new Scanner(System.in).nextLine();
                                    if (GenericChecks.chekone(name)) {
                                        patcient.setLastName(name.trim());
                                        patcient.setGender(patcientDao.allhospitals().get(i).getPatcients().get(j).getGender());
                                        patcient.setAge(patcientDao.allhospitals().get(i).getPatcients().get(j).getAge());
                                        patcient.setFirstName(patcientDao.allhospitals().get(i).getPatcients().get(j).getFirstName());
                                        patcientDao.updatePatcient(id, patcient);
                                        break;
                                    }
                                }
                            }
                            case 3 -> {
                                while (true) {
                                    System.out.println("Write age : ");
                                    try {
                                        int name = new Scanner(System.in).nextInt();
                                        if (name > 0) {
                                            patcient.setAge(name);
                                            patcient.setGender(patcientDao.allhospitals().get(i).getPatcients().get(j).getGender());
                                            patcient.setFirstName(patcientDao.allhospitals().get(i).getPatcients().get(j).getFirstName());
                                            patcient.setLastName(patcientDao.allhospitals().get(i).getPatcients().get(j).getLastName());
                                            patcientDao.updatePatcient(id, patcient);
                                            break;
                                        }
                                    } catch (InputMismatchException exception) {
                                        System.out.println("Write age please!");
                                        new Scanner(System.in).close();
                                    }
                                }
                            }
                            case 4 -> {
                                while (true) {
                                    System.out.println("Write gender (M||F): ");
                                    String name = new Scanner(System.in).nextLine();
                                    if (name.equalsIgnoreCase(Gender.MALE.name())) {
                                        patcient.setGender(Gender.MALE);
                                        patcient.setFirstName(patcientDao.allhospitals().get(i).getPatcients().get(j).getFirstName());
                                        patcient.setAge(patcientDao.allhospitals().get(i).getPatcients().get(j).getAge());
                                        patcient.setLastName(patcientDao.allhospitals().get(i).getPatcients().get(j).getLastName());
                                        patcientDao.updatePatcient(id, patcient);
                                        break;
                                    } else if (name.equalsIgnoreCase(Gender.FEMALE.name())) {
                                        patcient.setGender(Gender.FEMALE);
                                        patcient.setFirstName(patcientDao.allhospitals().get(i).getPatcients().get(j).getFirstName());
                                        patcient.setAge(patcientDao.allhospitals().get(i).getPatcients().get(j).getAge());
                                        patcient.setLastName(patcientDao.allhospitals().get(i).getPatcients().get(j).getLastName());
                                        patcientDao.updatePatcient(id, patcient);
                                        break;
                                    }
                                }
                            }
                        }

                    } catch (InputMismatchException exception) {
                        System.out.println("Write number please!");

                    }
                    return "Successfly updated";
                }
            }
        }
        throw new Notfound("Not found");

    }


    @Override
    public String addPatientsToHospital(Long ids, LinkedList<Patcient> patients) {
        int index = 0;
        for (int l = 0; l < patcientDao.allhospitals().size(); l++) {
            if (ids.equals(patcientDao.allhospitals().get(l).getId())) {
                for (int i = 0; i < patients.size(); i++) {
                    while (true) {
                        System.out.println("Write first name: ");
                        String name = new Scanner(System.in).nextLine();
                        if (GenericChecks.chekone(name)) {
                            patients.get(i).setFirstName(name.trim());
                            patients.get(i).setId(++id);
                            break;
                        }
                    }
                    while (true) {
                        System.out.println("Write last name: ");
                        String name = new Scanner(System.in).nextLine();
                        if (GenericChecks.chekone(name)) {
                            patients.get(i).setLastName(name.trim());
                            break;
                        }
                    }
                    while (true) {
                        System.out.println("Write age : ");
                        try {
                            int name = new Scanner(System.in).nextInt();
                            if (name > 0) {
                                patients.get(i).setAge(name);
                                break;
                            }
                        } catch (InputMismatchException exception) {
                            System.out.println("Write age please!");

                        }
                    }
                    while (true) {
                        System.out.println("Write gender (M||F): ");
                        String name = new Scanner(System.in).nextLine();
                        if (name.equalsIgnoreCase(Gender.MALE.name())) {
                            patients.get(i).setGender(Gender.MALE);
                            break;
                        } else if (name.equalsIgnoreCase(Gender.FEMALE.name())) {
                            patients.get(i).setGender(Gender.FEMALE);
                            break;
                        }
                        index = i;

                    }
                }

            }
        }
        patcientDao.addPatcient(index, patients);
        return "Success";
    }

    @Override
    public String myadd(Long id, LinkedList<Patcient> patcients) {
        boolean isyeas = true;
        int index = 0;
        for (int i = 0; i < patcientDao.allhospitals().size(); i++) {
            if (patcientDao.allhospitals().get(i).getId().equals(id)) {
                index = i;
                isyeas = false;
            }
        }
        if (!isyeas) {
            patcientDao.addPatcient(index, patcients);
            return "Success";
        }
        throw new Notfound("Not found");
    }

    @Override
    public Patcient getPatientById(Long id) {
        for (int i = 0; i < patcientDao.allhospitals().size(); i++) {
            for (int i1 = 0; i1 < patcientDao.allhospitals().get(i).getPatcients().size(); i1++) {
                if (id.equals(patcientDao.allhospitals().get(i).getPatcients().get(i1).getId())) {
                    return patcientDao.allhospitals().get(i).getPatcients().get(i1);
                }
            }
        }
        throw new Notfound("Not found");
    }

    @Override
    public Map<Integer, LinkedList<Patcient>> getPatientByAge() {
        Map<Integer, LinkedList<Patcient>> patcientMap = new HashMap<>();

        for (int i = 0; i < patcientDao.getPatcients().size(); i++) {
            if (!patcientMap.containsKey(patcientDao.getPatcients().get(i).getAge())) {
                LinkedList<Patcient> patcients = new LinkedList<>();
                Patcient patcient = patcientDao.getPatcients().get(i);
                LinkedList<Patcient> patcients1 = patcientMap.get(patcientDao.getPatcients().get(i).getAge());
                if (patcients1 != null) {
                    patcients.addAll(patcients1);
                }
                patcients.add(patcient);
                patcientMap.put(patcientDao.getPatcients().get(i).getAge(), patcients);
            } else {
                LinkedList<Patcient> patcients = new LinkedList<>();
                Patcient patcient = patcientDao.getPatcients().get(i);
                LinkedList<Patcient> patcients1 = patcientMap.get(patcientDao.getPatcients().get(i).getAge());
                if (patcients1 != null) {
                    patcients.addAll(patcients1);
                }
                patcients1.add(patcient);
                patcientMap.put(patcientDao.getPatcients().get(i).getAge(), patcients1);
                patcients.add(patcientDao.getPatcients().get(i));
            }
        }
        return patcientMap;
    }

    @Override
    public LinkedList<Patcient> sortPatientsByAge(String ascOrDesc) {
        LinkedList<Patcient> patcients = patcientDao.getPatcients();
        if (ascOrDesc.equalsIgnoreCase("asc")) {
            patcients.sort(Patcient.sortbyage);
            return patcients;
        } else if (ascOrDesc.equalsIgnoreCase("Desc")) {
            patcients.sort(Patcient.sortbyage.reversed());
            return patcients;
        }
        throw new Notfound("Write aasc or desc");
    }
}
