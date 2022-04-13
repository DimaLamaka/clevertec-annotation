package ru.clevertec.annotation.dao;

import ru.clevertec.annotation.entity.Employee;
import ru.clevertec.annotation.aop.MyLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class EmployeeDAO implements EntityDAO<Employee> {
    private final List<Employee> employees = new ArrayList<>();

    @Override
    @MyLogger
    public Employee save(Employee employee) {
        employees.add(employee);
        return employee;
    }

    @Override
    @MyLogger
    public Employee update(Employee employee) {
        employees.stream().filter(e -> e.getId().equals(employee.getId())).forEach(e -> e = employee);
        return employee;
    }

    @Override
    @MyLogger
    public void delete(Long id) {
        employees.removeIf(e -> e.getId().equals(id));
    }

    @Override
    @MyLogger
    public Employee getById(Long id) {
        return employees.stream().filter(e -> e.getId().equals(id)).findFirst().orElseThrow(NoSuchElementException::new);
    }

    @Override
    @MyLogger
    public List<Employee> getAll() {
        return employees;
    }
}
