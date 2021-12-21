package ru.skypro;

public class Employee {
    private int idEmployee;
    private String firstName;
    private String secondName;
    private String lastName;
    public int department;
    private Float salary;
    private static int counter;


    public Employee(String secondName, String firstName, String lastName, int department, Float salary) {
        counter++;
        this.idEmployee = getCounter();
        this.secondName = secondName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;

    }


    public String getFullName() {
        return secondName + " " + firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public Float getSalary() {
        return salary;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public int getCounter() {
        return counter;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + idEmployee + '\'' +
                "department='" + idEmployee + '\'' +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }


}
