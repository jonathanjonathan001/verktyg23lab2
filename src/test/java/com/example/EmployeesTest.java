package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesTest {

    BankServiceImpl bankService = new BankServiceImpl();

    EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);

    @Test
    void whenPayEmployeesIsCalledWithOneEmployeePaymentsisOne() {
        Employees employees = new Employees(employeeRepository, bankService);
        Mockito.when(employeeRepository.findAll()).thenReturn(List.of(new Employee("123", 100000)));
        int nPayments = employees.payEmployees();
        assertEquals(1, nPayments);
    }

    @Test
    void whenPayEmployeesIsCalledWithSpecialFailIdPaymentsIsZero() {
        Employees employees = new Employees(employeeRepository, bankService);
        Mockito.when(employeeRepository.findAll()).thenReturn(List.of(new Employee("fail", 100000)));
        int nPayments = employees.payEmployees();
        assertEquals(0, nPayments);
    }

}