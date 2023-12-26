package main.models.department;

import main.models.Department;

import java.util.LinkedList;

public interface DepartmentService {
    LinkedList<Department> getAllDepartmentByHospital(Long id);
    Department findDepartmentByName(String name);
}
