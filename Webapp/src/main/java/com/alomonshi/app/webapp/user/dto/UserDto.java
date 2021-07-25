package com.alomonshi.app.webapp.user.dto;

import com.alomonshi.app.service.user.validator.MobilePhone;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {

    private Long id;

    @NotNull(message = "name can not be null")
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    @Size(min = 6, max = 12)
    private String name;

    @Email
    private String email;

    @MobilePhone(message = "{com.alomonshi.app.validation.mobilephone}")
    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
