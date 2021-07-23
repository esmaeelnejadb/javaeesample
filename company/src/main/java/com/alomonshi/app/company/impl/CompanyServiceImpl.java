package com.alomonshi.app.company.impl;

import com.alomonshi.app.service.entity.Company;
import com.alomonshi.app.service.services.company.CompanyService;

import java.util.ArrayList;
import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    private static List<Company> companies = new ArrayList<>();

    @Override
    public void addCompany(Company company) {
        company.setId(companies.size() + 1);
        companies.add(company);
    }

    @Override
    public void deleteCompany(Integer id) {
        companies.removeIf(o -> o.getId().equals(id));
    }

    @Override
    public void updateCompany(Company company) {
        companies.stream().filter(o -> o.getId().equals(company.getId())).forEach(f -> f.setName(company.getName()));
    }

    @Override
    public Company getCompany(Integer id) {
        if (companies.stream().anyMatch(o -> o.getId().equals(id)))
            return companies.stream().filter(o -> o.getId().equals(id)).findFirst().get();
        return null;
    }
}
