package com.kodilla.hibernate.manytomany.facade.api;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchFacade.class);
    private final SearchService searchService;
    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public SearchFacade(SearchService searchService, CompanyDao companyDao, EmployeeDao employeeDao) {
        this.searchService = searchService;
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> processCompanyQuerySearch(List<Company> companies, String companySearchQuery) throws SearchProcessingException {

        companyDao.deleteAll();

        for (Company company : companies) {
            companyDao.save(company);
        }

        LOGGER.info("Searching company by name, QUERY: " + companySearchQuery);
        List<Company> companiesQueryResponse = searchService.searchCompaniesByQueryName(companySearchQuery);

        if (companiesQueryResponse.isEmpty()) {
            LOGGER.error(SearchProcessingException.ERR_NOT_FOUND_COMPANY);
            throw new SearchProcessingException(SearchProcessingException.ERR_NOT_FOUND_COMPANY);
        }

        LOGGER.info("Company query result: ");
        companiesQueryResponse.stream().forEach(company -> System.out.println("Company " + company.getName()));


        return companiesQueryResponse;

    }

    public List<Employee> processEmployeeQuerySearch(List<Employee> employees, final String employeeSearchQuery) throws SearchProcessingException {

        employeeDao.deleteAll();

        for (Employee employee : employees) {
            employeeDao.save(employee);
        }

        LOGGER.info("Searching employee by last name, QUERY: " + employeeSearchQuery);
        List<Employee> employeesQueryResponse = searchService.searchEmployeesByQueryName(employeeSearchQuery);
        if (employeesQueryResponse.isEmpty()) {
            LOGGER.error(SearchProcessingException.ERR_NOT_FOUND_EMPLOYEE);
            throw new SearchProcessingException(SearchProcessingException.ERR_NOT_FOUND_EMPLOYEE);
        }

        LOGGER.info("Employees query result: ");
        employeesQueryResponse.stream().forEach(employee -> System.out.println("Employee :" + employee.getFirstName()));

        return employeesQueryResponse;
    }
}
