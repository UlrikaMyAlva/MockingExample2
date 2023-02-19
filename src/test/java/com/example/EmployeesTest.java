package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

    @BeforeEach
    void Init() {
        MockitoAnnotations.initMocks(this);
    }

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
    public void testEmployeeRepositorySpyOnListFindAll() { //Testklass med Mockito
       //Spy is used to spy on the list in employeeRepository
        List<Employee> spyList = spy(employeeRepository.findAll());
        when(spyList.size()).thenReturn(3);
        assertEquals(3, spyList.size());
    }

    @Test
    public void testEmployeeRepositorySave () {
        //When you use save in employeeRepository with employee, return employee
        when(employeeRepository.save(employee)).thenReturn(employee);
        assertEquals(employee, employeeRepository.save(employee));
    }

    @Test
    public void testPayEmployeesEmployeeRepository () {

        List<Employee> fakeList = new ArrayList<>();
        fakeList.add(employee);
        fakeList.add(employee);
        fakeList.add(employee);

        EmployeeRepository forTest = new EmployeeRepository() {
            @Override
            public List<Employee> findAll() {
                return fakeList;
            }

            @Override
            public Employee save(Employee e) {
                return null;
            }
        };

        Employees testWithFakeList = new Employees(forTest, bankService);

        assertEquals(3, testWithFakeList.payEmployees());

    }

    @Test
    public vo
}