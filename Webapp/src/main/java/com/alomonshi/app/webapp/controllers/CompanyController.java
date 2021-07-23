package com.alomonshi.app.webapp.controllers;

import com.alomonshi.app.company.impl.CompanyServiceImpl;
import com.alomonshi.app.service.entity.Company;
import com.alomonshi.app.service.services.company.CompanyService;
import com.alomonshi.app.webapp.dtos.CompanyDto;

import javax.validation.*;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("company")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController() {
        this.companyService = new CompanyServiceImpl();
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public CompanyDto getCompany (@QueryParam("id") Integer id) {
        CompanyDto companyDto = new CompanyDto();
        Company company = companyService.getCompany(id);
        if (company != null) {
            companyDto.setId(company.getId());
            companyDto.setName(company.getName());
        }
        return companyDto;
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCompany (CompanyDto companyDto) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<CompanyDto>> violations = validator.validate(companyDto);

        for (ConstraintViolation<CompanyDto> violation: violations)
            System.out.println(violation.getPropertyPath() + " " + violation.getMessage());


        Company company = new Company();
        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setActive(false);
        companyService.addCompany(company);
    }
}