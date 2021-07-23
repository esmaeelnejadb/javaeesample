package com.alomonshi.app.service.company.services;

import com.alomonshi.app.service.company.entity.Company;

public interface CompanyService {

    void add(Company company);
    void delete(Long id);
    void update(Company company);
    Company get(Long id);
}
