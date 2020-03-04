package de.telran.service;

import de.telran.model.Department;

import java.util.List;

public class DepartmentService {
    private List<Department> departments;

    public DepartmentService(List<Department> departments) {
        this.departments = departments;
    }

    public long getNumberEmployees(int salaryBound, String codeStart) {
        return departments.stream().filter(x -> x.getCode().startsWith(codeStart))
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getSalary() >= salaryBound)
                .count();
    }
}
