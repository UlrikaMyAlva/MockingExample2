package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeesTest {


    @Mock
    Employee employee = mock(Employee.class);
    EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
    BankService bankService = mock(BankService.class);
    Employees employees = mock(Employees.class);


    //Tests without Mockito
    @Test
    void testIfEmployeeIsPaidByCreatingAnEmployee () {
        //Here an employee is created to test if you can pay them.
        Employee employee = new Employee("1212", 30000);
        employee.setPaid(true);
        assertTrue(employee.isPaid());
    }

    //Tests with Mockito


    @Test
    public void testEmployeeRepositorySpyOnListFindAll() { //Testklass med Mockito

       //Spy is used to spy on the list in employeeRepository

        List<Employee> spyList = spy(employeeRepository.findAll());
        when(spyList.size()).thenReturn(3);
        assertEquals(3, spyList.size());

    }


    @Test
    public void testPayEmployeesEmployeeRepositoryCalled() {

        /*

        Tests that findall in employeeRepository is called.

         */

        Employees employees1 = new Employees(employeeRepository, bankService);
        employees1.payEmployees();

        verify(employeeRepository).findAll();

    }


    @Test
    public void testReturnedPaymentsAndEmployeeRepository() {

        /*
        Tests that payEmployees returns right amount of payments.

         */

        List<Employee> test = new ArrayList<>();
        test.add(employee);
        test.add(employee);
        test.add(employee);

        Employees employees1 = new Employees(employeeRepository, bankService);

        when(employeeRepository.findAll()).thenReturn(test);
        int payments = employees1.payEmployees();

        assertEquals(3, payments);

    }

    @Test
    public void testBankserviceBeingCalled() {

        /*

        Tests if Bankservice.pay is used.

         */

        List<Employee> test = new ArrayList<>();
        test.add(employee);

        Employees employees1 = new Employees(employeeRepository, bankService);

        when(employeeRepository.findAll()).thenReturn(test);

        employees1.payEmployees();

        verify(bankService).pay(null, 0.0d);

    }


}