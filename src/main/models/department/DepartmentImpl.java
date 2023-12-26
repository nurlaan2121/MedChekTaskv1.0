package main.models.department;

import main.models.Department;
import main.models.GenericChecks;
import main.models.GenericService;
import main.models.Hospital;
import main.myExceptions.Notfound;

import java.util.LinkedList;
import java.util.Scanner;

public class DepartmentImpl extends GenericChecks<Department> implements DepartmentService, GenericService<Department> {
    private final DepartmentDao departmentDao;
    public Long id = 0L;

    public DepartmentImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    GenericChecks<Department> genericChecks = new GenericChecks<>();

    @Override
    public String add(Long hospitalId, Department department) {
        for (int i = 0; i < departmentDao.getallHostipals().size(); i++) {
            if (hospitalId.equals(departmentDao.getallHostipals().get(i).getId())) {
                while (true) {
                    System.out.println("Write title department: ");
                    String name = new Scanner(System.in).nextLine().trim();
                    if (GenericChecks.chekone(name) && genericChecks.unicname(departmentDao.getallHostipals(),name,i)) {
                        department.setId(++id);
                        department.setDepartmentName(name.trim());
                        LinkedList<Department> departments = departmentDao.getallHostipals().get(i).getDepartments();
                        departments.add(department);
                        departmentDao.addDepartmentToHospitla(i, departments);
                        return "Success!";
                    }
                }
            }
        }
        throw new Notfound("Not found");
    }

    @Override
    public void removeById(Long id) {
        boolean isdeleted = true;
        for (int i = 0; i < departmentDao.getallHostipals().size(); i++) {
            for (int i1 = 0; i1 < departmentDao.getallHostipals().get(i).getDepartments().size(); i1++) {
                if (id.equals(departmentDao.getallHostipals().get(i).getDepartments().get(i1).getId())) {
                    departmentDao.getallHostipals().get(i).getDepartments().remove(i1);
                    System.out.println("Success");
                    isdeleted = false;
                    break;
                }
            }
        }
        if (isdeleted){
            throw new Notfound("Not found");
        }

    }

    @Override
    public String updateById(Long id, Department department) {
        for (int i = 0; i < departmentDao.getallHostipals().size(); i++) {
            for (int j = 0; j < departmentDao.getallHostipals().get(i).getDepartments().size(); j++) {
                if (departmentDao.getallHostipals().get(i).getDepartments().get(j).getId().equals(id)) {
                    while (true) {
                        System.out.println("Write title department: ");
                        String name = new Scanner(System.in).nextLine();
                        if (GenericChecks.chekone(name) && genericChecks.unicname(departmentDao.getallHostipals(),name,i)) {
                            department.setDepartmentName(name.trim());
                            departmentDao.getallHostipals().get(i).getDepartments().get(j).setDepartmentName(department.getDepartmentName());
                            return "Success!";
                        }
                    }
                }

            }

        }
        throw new Notfound("Not found");
    }


    @Override
    public LinkedList<Department> getAllDepartmentByHospital(Long id) {
        for (Hospital hospital :
                departmentDao.getallHostipals()) {
            if (hospital.getId().equals(id)) {
                return hospital.getDepartments();
            }

        }
        throw new Notfound("Not found");
    }

    @Override
    public Department findDepartmentByName(String name) {
        for (int i = 0; i < departmentDao.getallHostipals().size(); i++) {
            for (int i1 = 0; i1 < departmentDao.getallHostipals().get(i).getDepartments().size(); i1++) {
                if (name.equalsIgnoreCase(departmentDao.getallHostipals().get(i).getDepartments().get(i1).getDepartmentName())) {
                    return departmentDao.getallHostipals().get(i).getDepartments().get(i1);
                }
            }
        }
        throw new Notfound("Not found");
    }
}
