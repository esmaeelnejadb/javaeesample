package com.alomonshi.app.webapp.company.controller;

import com.alomonshi.app.service.company.entity.Company;
import com.alomonshi.app.service.company.services.CompanyService;
import com.alomonshi.app.webapp.company.dtos.CompanyDto;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("company")
public class CompanyController {

    @Inject
    private CompanyService companyService;

    @Inject
    Validator validator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CompanyDto getCompany (@QueryParam("id") Long id) {
        CompanyDto companyDto = new CompanyDto();
        Company company = companyService.get(id);
        if (company != null) {
            companyDto.setId(company.getId());
            companyDto.setName(company.getName());
        }
        return companyDto;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCompany (CompanyDto companyDto) {

        Set<ConstraintViolation<CompanyDto>> violations = validator.validate(companyDto);

        violations.forEach(f-> System.out.println(f.getMessage()));


        Company company = new Company();
        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setActive(false);
        companyService.add(company);
    }
}