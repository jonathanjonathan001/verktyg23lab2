package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    Employee employee = new Employee("123", 100000);

    @Test
    void getIdReturnsId() {

        assertEquals("123", employee.getId());
    }

    @Test
    void setIdsetsId() {
        employee.setId("124");

        assertEquals("124", employee.getId());
    }

    @Test
    void getSalaryReturnsSalary() {
        assertEquals(100000, employee.getSalary());
    }

    @Test
    void setSalarySetsSalary() {
        employee.setSalary(120000);
        assertEquals(120000, employee.getSalary());
    }

    @Test
    void setPaidSetsPaid() {
        employee.setPaid(true);
        assertTrue(employee.isPaid());
    }

    @Test
    void isPaidReturnsPaid() {
        employee.setPaid(true);
        assertTrue(employee.isPaid());
    }

    @Test
    void toStringReturnsCorrectData() {
        assertEquals("Employee [id=123, salary=100000.0]", employee.toString());
    }

}