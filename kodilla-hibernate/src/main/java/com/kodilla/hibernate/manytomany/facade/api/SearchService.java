package com.kodilla.hibernate.manytomany.facade.api;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    private final List<Company> companies = new ArrayList<>();
    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public SearchService(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> searchCompaniesByQueryName(final String companyName) {
        return  companyDao.retrieveCompaniesBySpecifiedQueryName("%" + companyName + "%");
    }

    public List<Employee> searchEmployeesByQueryName(final String lastName) {
        return employeeDao.retrieveEmployeesBySpecifiedName("%" + lastName + "%");
    }
}
