package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeesTest {


    @Mock
    Employee employee = mock(Employee.class);
    EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

    @BeforeEach
    void Init() {
        MockitoAnnotations.initMocks(this);
    }

    //Tests with own parameters
    @Test
    void testIfEmployeeIsPaidByCreatingAnEmployee () {
        //Here an employee is created to test if you can pay them.
        Employee employee = new Employee("1212", 30000);
        employee.setPaid(true);
        assertTrue(employee.isPaid());
    }

    //Tests using Mockito
    @Test
    void testEmployeeId () {
        //Here you do not need to create an employee because you use mock.
        //The employee is already created under the annotation @mock
        when(employee.getId()).thenReturn("1212");
        assertEquals("1212",employee.getId());
    }

    @Test
    void testEmployeeIsPaid () {
        when(employee.isPaid()).thenReturn(true);
        assertTrue(employee.isPaid());
    }

    @Test
    void testEmployeeGetSalary() {
        when(employee.getSalary()).thenReturn(30000.00);
        assertEquals(30000.00, employee.getSalary());
    }

    @Test
    public void spyOnEmployeeRepository() { //Testklass med Mockito
       //Spy is used to spy on the list in employeeRepository
        List<Employee> spyList = spy(employeeRepository.findAll());
        when(spyList.size()).thenReturn(3);
        assertEquals(3, spyList.size());
    }

    void testDoubleEmployeeRepository() { //Skapa egna inputs att testa med

    }
}