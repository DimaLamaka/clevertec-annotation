package ru.clevertec.annotation;

import ru.clevertec.annotation.dao.EmployeeDAO;
import ru.clevertec.annotation.dao.EntityDAO;
import ru.clevertec.annotation.entity.Employee;
import ru.clevertec.annotation.entity.Sex;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee(1L,"petya",16,Sex.MALE);
        Employee employee1 = new Employee(2L,"vasya",19,Sex.MALE);
        Employee employee2 = new Employee(3L,"katya",24,Sex.FEMALE);
        Employee employee3 = new Employee(4L,"lera",16,Sex.FEMALE);
        EntityDAO<Employee> dao = new EmployeeDAO();
        dao.save(employee);
        dao.save(employee1);
        dao.save(employee2);
        dao.save(employee3);
        System.out.println("------------------------------------");
        System.out.println(dao.getAll());
        System.out.println("-------------------------------------");
        dao.getById(1L);
        System.out.println("-------------------------------------");
        dao.delete(1L);
        dao.getAll();
        System.out.println("-------------------------------------");
        employee1.setName("kolya");
        employee1.setAge(20);
        dao.update(employee1);
        dao.getAll();
    }
}
