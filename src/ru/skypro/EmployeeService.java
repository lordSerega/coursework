package ru.skypro;

public class EmployeeService {


    public static boolean isNullEmployee(Employee employee) {
        if (employee != null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNullEmployeeList(Employee[] employees) {
        if (employees[0] == null) {
            return false;
        } else {
            return true;
        }
    }

    public static int getCountInList(Employee[] employees) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return count;
    }

    public static boolean isDepartmentExists(Employee[] employees, int department) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                return true;
            }
        }
        return false;
    }

    public static void add(Employee[] employees, Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
    }

    public static void printEmployees(Employee[] employees) {

        for (Employee employee : employees) {
            if (isNullEmployee(employee)) {
                System.out.println(employee.toString());
            }
        }
    }

    public static String printResult(Employee employee) {

        if (employee != null) {
            return employee.getFullName();

        } else {
            return "Список сотрудников пуст";
        }

    }

    public static void printEmployeesFullName(Employee[] employees) {
        if (isNullEmployeeList(employees)) {
            for (Employee employee : employees) {
                if (isNullEmployee(employee)) {
                    System.out.println(employee.getFullName());
                }
            }
        } else {
            System.out.println("Список сотрудников пуст");
        }
    }

    public static Employee[] findEmployeesInDepartment(Employee[] employees, int department) {
        Employee[] employeesInDepartment = new Employee[employees.length];
        for (Employee employee : employees) {
            if (employee.getDepartment() == department && isNullEmployee(employee)) {
                add(employeesInDepartment, employee);
            }
        }
        return employeesInDepartment;
    }


    public static Float allSalary(Employee[] employees) {
        if (isNullEmployeeList(employees)) {
            Float sum = 0F;
            for (Employee employee : employees) {
                if (isNullEmployee(employee)) {
                    sum += employee.getSalary();
                }
            }
            return sum;
        } else {
            return null;
        }
    }

    public static Employee minSalary(Employee[] employees) {
        if (isNullEmployeeList(employees)) {
            Float min = employees[0].getSalary();
            Employee minEmployees = employees[0];
            for (Employee employee : employees) {
                if (isNullEmployee(employee) && min > employee.getSalary()) {
                    min = employee.getSalary();
                    minEmployees = employee;
                }
            }
            return minEmployees;
        } else {
            return null;
        }
    }

    public static Employee maxSalary(Employee[] employees) {
        if (isNullEmployeeList(employees)) {
            Float max = employees[0].getSalary();
            Employee maxEmployees = employees[0];
            for (Employee employee : employees) {
                if (isNullEmployee(employee) && max < employee.getSalary()) {
                    max = employee.getSalary();
                    maxEmployees = employee;
                }
            }
            return maxEmployees;
        } else {
            return null;
        }
    }

    public static Float midSalary(Employee[] employees) {
        if (isNullEmployeeList(employees)) {
            Float sum = allSalary(employees);
            return sum / getCountInList(employees);
        } else {
            return null;
        }
    }

    public static Boolean indexSalary(Employee[] employees, Float index) {
        boolean success = false;
        for (Employee employee : employees) {
            if (isNullEmployee(employee)) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
                success = true;
            }
        }
        return success;
    }

    public static Employee minSalaryByDepartment(Employee[] employees, int department) {
        if (isNullEmployeeList(employees) && isDepartmentExists(employees, department)) {
            Employee[] employeesInDepartment = findEmployeesInDepartment(employees, department);
            return minSalary(employeesInDepartment);
        }
        return null;
    }

    public static Employee maxSalaryByDepartment(Employee[] employees, int department) {
        if (isNullEmployeeList(employees) && isDepartmentExists(employees, department)) {
            Employee[] employeesInDepartment = findEmployeesInDepartment(employees, department);
            return maxSalary(employeesInDepartment);
        }
        return null;
    }

    public static Float midSalaryByDepartment(Employee[] employees, int department) {
        if (isNullEmployeeList(employees) && isDepartmentExists(employees, department)) {
            Employee[] employeesInDepartment = findEmployeesInDepartment(employees, department);
            return midSalary(employeesInDepartment);
        }
        return null;
    }

    public static Float allSalaryByDepartment(Employee[] employees, int department) {
        if (isNullEmployeeList(employees) && isDepartmentExists(employees, department)) {
            Employee[] employeesInDepartment = findEmployeesInDepartment(employees, department);
            return allSalary(employeesInDepartment);
        }
        return null;
    }

    public static Boolean indexSalaryInDepartment(Employee[] employees, int department, Float index) {
        if (isNullEmployeeList(employees) && isDepartmentExists(employees, department)) {
            Employee[] employeesInDepartment = findEmployeesInDepartment(employees, department);
            return indexSalary(employeesInDepartment, index);
        }
        return null;
    }

    public static void printEmployeesInDepartment(Employee[] employees, int department) {
        if (isNullEmployeeList(employees) && isDepartmentExists(employees, department)) {
            Employee[] employeesInDepartment = findEmployeesInDepartment(employees, department);
            for (Employee employee : employeesInDepartment) {
                if (isNullEmployee(employee)) {
                    int id = employee.getIdEmployee();
                    Float salary = employee.getSalary();
                    String fullName = employee.getFullName();
                    String result = String.format("ID: %d | EMPLOYEE: %s | SALARY: %f", id, fullName, salary);
                    System.out.println(result);
                }
            }
        }
    }

    public static void printEmployeesInDepartmentBetweenSalary(Employee[] employees, int department, Float findSalary) {
        if (isNullEmployeeList(employees) && isDepartmentExists(employees, department)) {
            Employee[] employeesInDepartment = findEmployeesInDepartment(employees, department);
            for (Employee employee : employeesInDepartment) {
                if (isNullEmployee(employee) && employee.getSalary() >= findSalary) {
                    int id = employee.getIdEmployee();
                    Float salary = employee.getSalary();
                    String fullName = employee.getFullName();
                    String result = String.format("ID: %d | EMPLOYEE: %s | SALARY: %f", id, fullName, salary);
                    System.out.println(result);
                }
            }
        }
    }

}
