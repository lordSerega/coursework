package ru.skypro;

public class Main {

    public static void main(String[] args) {

        Employee[] employees = new Employee[3];

        EmployeeService.add(employees, new Employee("Kaplin", "Sergey", "Evgenevich", 1, 5F));
        EmployeeService.add(employees, new Employee("Sostin", "Sergey", "Yurevich", 2, 10F));
        EmployeeService.add(employees, new Employee("Boldireva", "Lidia", "Vladimirovna", 1, 2F));

        //toString
        EmployeeService.printEmployees(employees);

        //Сумма всех зарплат
        System.out.println("Cумма затрат на зарплаты в месяц:" + EmployeeService.allSalary(employees));

        //Минимальная зарплата сотрудника
        Employee min = EmployeeService.minSalary(employees);
        System.out.println("Минимальная зарпалта у сотрудника: " + EmployeeService.printResult(min));

        //Максимальная зарплата сотрудника
        Employee max = EmployeeService.maxSalary(employees);
        System.out.println("Максимальная зарпалта у сотрудника: " + EmployeeService.printResult(max));

        //Средняя зарпалата сотрудника
        System.out.println("Средняя зарплата = " + EmployeeService.midSalary(employees));

        //Полные ФИО
        EmployeeService.printEmployeesFullName(employees);

        //Индексация ЗП
        Boolean indexSalary = EmployeeService.indexSalary(employees, 0F);
        if (indexSalary) {
            EmployeeService.printEmployees(employees);
        } else {
            System.out.println("Список сотрудников пуст");
        }

        //Минимальная зп в отделе
        int department = 1;
        Employee minInDepartment = EmployeeService.minSalaryByDepartment(employees, department);
        if (minInDepartment != null) {
            System.out.println("В отделе " + minInDepartment.getDepartment() + " минимальная зарпалта у сотрудника: " + EmployeeService.printResult(minInDepartment));
        }

        //Максимальная зп в отделе
        Employee maxInDepartment = EmployeeService.maxSalaryByDepartment(employees, department);
        if (maxInDepartment != null) {
            System.out.println("В отделе " + maxInDepartment.getDepartment() + " максимальная зарпалта у сотрудника: " + EmployeeService.printResult(maxInDepartment));
        }

        //Средняя зп в отделе
        System.out.println("В отделе " + department + " cредняя зарплата = " + EmployeeService.midSalaryByDepartment(employees, department));

        //Сумма зп в отделе
        System.out.println("В отделе " + department + " сумма затрат на зарплату = " + EmployeeService.allSalaryByDepartment(employees, department));

        //Индексация ЗП в отделе
        Boolean indexSalaryDepartment = EmployeeService.indexSalaryInDepartment(employees, department, 100F);
        if (indexSalaryDepartment != null) {
            EmployeeService.printEmployees(employees);
        } else {
            System.out.println("Список сотрудников пуст");
        }

        //Сотрудники в отделе
        EmployeeService.printEmployeesInDepartment(employees,department);

        //Сотрудники с ЗП больше или равно
        EmployeeService.printEmployeesInDepartmentBetweenSalary(employees, department,11F);
    }
}
