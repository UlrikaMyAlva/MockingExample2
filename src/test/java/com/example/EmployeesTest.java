package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeesTest {

    @BeforeEach
    void Init() {

    }

    //Tests with own parameters
    @Test
    void testId () {
        Employee employee = new Employee("1212", 30000);
        employee.setPaid(true);
        assertTrue(employee.isPaid());
    }

    //Tests using Mockito
    @Test
    void testIdWithMock () {
        Employee employee = mock(Employee.class);
        when(employee.isPaid()).thenReturn(true);
        assertTrue(employee.isPaid());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void spyOnEmployeeRepository() { //Testklass med Mockito
        EmployeeRepository dummyEmployee = mock(EmployeeRepository.class);
        List<Employee> spyList = spy(dummyEmployee.findAll());
        when(spyList.size()).thenReturn(3);
        assertTrue(spyList.size()==3);
    }

    void testDoubleEmployeeRepository() { //Skapa egna inputs att testa med

    }
}