package com.alomonshi.app.service.services.company;

import com.alomonshi.app.service.entity.Company;

public interface CompanyService {

    void addCompany (Company company);
    void deleteCompany (Integer id);
    void updateCompany (Company company);
    Company getCompany (Integer id);
}
