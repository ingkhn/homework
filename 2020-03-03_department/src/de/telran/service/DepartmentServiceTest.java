package de.telran.service;

import de.telran.model.Department;
import de.telran.model.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DepartmentServiceTest {

    @Test
    public void testGetNumberEmployees_expectedQtnDep() {
        Employee empl1 = new Employee("Vasya", 1500);
        Employee empl2 = new Employee("Masha", 2500);
        Employee empl3 = new Employee("Petya", 3000);
        List<Employee> employees = Arrays.asList(empl1, empl2, empl3);

        Department d1 = new Department("IT", "11134", employees);
        List<Department> departments = Arrays.asList(d1);

        DepartmentService ds = new DepartmentService(departments);

        assertEquals(2, ds.getNumberEmployees(2000, "111"));
    }

    @Test
    public void testGetNumberEmployees_smallSalary_expectedNull() {
        Employee empl1 = new Employee("Vasya", 1500);
        Employee empl2 = new Employee("Masha", 2500);
        Employee empl3 = new Employee("Petya", 3000);
        List<Employee> employees = Arrays.asList(empl1, empl2, empl3);

        Department d1 = new Department("IT", "11134", employees);
        List<Department> departments = Arrays.asList(d1);

        DepartmentService ds = new DepartmentService(departments);

        assertEquals(0, ds.getNumberEmployees(5000, "111"));
    }

    @Test
    public void testGetNumberEmployees_wrongDep_expectedNull() {
        Employee empl1 = new Employee("Vasya", 1500);
        Employee empl2 = new Employee("Masha", 2500);
        Employee empl3 = new Employee("Petya", 3000);
        List<Employee> employees = Arrays.asList(empl1, empl2, empl3);

        Department d1 = new Department("IT", "11334", employees);
        List<Department> departments = Arrays.asList(d1);

        DepartmentService ds = new DepartmentService(departments);

        assertEquals(0, ds.getNumberEmployees(1000, "111"));
    }
}