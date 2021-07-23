package com.alomonshi.app.company.impl;

import com.alomonshi.app.service.company.entity.Company;
import com.alomonshi.app.service.company.services.CompanyService;

import java.util.ArrayList;
import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    private static List<Company> companies = new ArrayList<>();

    @Override
    public void add(Company company) {
        company.setId(companies.size() + 1L);
        companies.add(company);
    }

    @Override
    public void delete(Long id) {
        companies.removeIf(o -> o.getId().equals(id));
    }

    @Override
    public void update(Company company) {
        companies.stream().filter(o -> o.getId().equals(company.getId())).forEach(f -> f.setName(company.getName()));
    }

    @Override
    public Company get(Long id) {
        if (companies.stream().anyMatch(o -> o.getId().equals(id)))
            return companies.stream().filter(o -> o.getId().equals(id)).findFirst().get();
        return null;
    }
}
