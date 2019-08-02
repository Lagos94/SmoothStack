package com.st.lms.model;

import java.util.Objects;

public class Employee {
    private int employeeId;
    private String name;
    private int salary;

    private Integer managerId;
    private Department department;

    public Employee(){}

    public Employee(int employeeId, String name, int salary, Integer managerId, Department department){
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        this.managerId = managerId;
        this.department = department;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId &&
                salary == employee.salary &&
                Objects.equals(name, employee.name) &&
                Objects.equals(managerId, employee.managerId) &&
                Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, name, salary, managerId, department);
    }
}
