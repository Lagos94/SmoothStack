package com.st.lms.app;

import com.st.lms.model.Department;
import com.st.lms.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = createSmallCompany();
        //Max salary
        Employee empWithMaxSalary = employees
                .stream()
                .reduce(new Employee(), (e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2);
        System.out.println(empWithMaxSalary.getName());

        //List employees whose Manager is Julie

        List<Employee> empWithMgr =
                employees
                        .stream()
                        .filter(e -> e.getManagerId() != null && e.getManagerId() == 3)
                        .collect(Collectors.toList());
        String result = empWithMgr
                .stream()
                .map(e -> e.getName())
                .collect(Collectors.joining(" and ", " Same Manager: ", " report to Julie"));
        System.out.println(result);

        //Who has neither manager

        System.out.println("Below the list of employees with no manager: ");
        employees
                .stream()
                .filter(e -> e.getManagerId() == null) // There is an issue here we need to add to address
                .forEach(e -> System.out.println(e.getName()));
    }

        private static List<Employee> createSmallCompany(){

        Department technologyDept = new Department();
        technologyDept.setId(1);
        technologyDept.setDepartmentName("Technology");

        Department hrDept = new Department();
        hrDept.setId(2);
        hrDept.setDepartmentName("Human Resource");

        Department payrollDept = new Department();
        payrollDept.setId(3);
        payrollDept.setDepartmentName("Payroll");

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Tom", 200000, null, hrDept));
        employees.add(new Employee(2, "Joe", 95000, 1, hrDept));

        employees.add(new Employee(3, "Julie", 180000, null, technologyDept));
        employees.add(new Employee(4, "Adam", 140000, 3, technologyDept));
        employees.add(new Employee(5, "James", 135000, 3, technologyDept));

        employees.add(new Employee(6, "Jake", 125000, null, payrollDept));

        return employees;
    }
}
