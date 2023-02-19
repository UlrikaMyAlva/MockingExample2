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

    @Test
    void testId () {

    }

    //Test using Mockito
    @SuppressWarnings("unchecked")
    @Test
    public void spyOnEmployeeRepository() { //Testklass med Mockito
        EmployeeRepository dummyEmployee = mock(EmployeeRepository.class);
        List<Employee> spyList = spy(dummyEmployee.findAll());
        when(spyList.size()).thenReturn(5);
        assertTrue(spyList.size()==5);
    }

    void testDoubleEmployeeRepository() { //Skapa egna inputs att testa med

    }
}