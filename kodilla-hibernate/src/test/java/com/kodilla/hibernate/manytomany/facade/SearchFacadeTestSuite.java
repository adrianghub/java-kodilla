package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.facade.api.SearchFacade;
import com.kodilla.hibernate.manytomany.facade.api.SearchProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SearchFacadeTestSuite {

    @Autowired
    private SearchFacade searchFacade;

    @Test
    void testSearchCompaniesByName() {
        // Given
        List<Company> companies = new ArrayList<>();

        companies.add(new Company("First Company"));
        companies.add(new Company("Second Company"));
        companies.add(new Company("Third Company"));
        companies.add(new Company("Fourth Company"));

        // When & Then
        try {
            List<Company> queryResults = searchFacade.processCompanyQuerySearch(companies, "Th");
            assertEquals(queryResults.size(), 2);
        } catch (SearchProcessingException e) {
        }
    }

    @Test
    void testSearchEmployeesByName() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Dariusz", "Smith"));
        employees.add(new Employee("Stephanie", "Clarckson"));
        employees.add(new Employee("Lindar", "Kovalsky"));
        employees.add(new Employee("Dariusz", "Nowak"));

        //When
        try {
            List<Employee> queryResults = searchFacade.processEmployeeQuerySearch(employees, "ar");
            assertEquals(queryResults.size(), 1);
        } catch (SearchProcessingException e) {
        }
    }
}
