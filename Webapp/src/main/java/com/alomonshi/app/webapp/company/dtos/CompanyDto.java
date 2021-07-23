package com.alomonshi.app.webapp.company.dtos;
import com.alomonshi.app.webapp.picture.dto.PictureDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class CompanyDto {
    private Long id;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String name;

    private Boolean active;


    private List<PictureDto> pictureDtoList;

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<PictureDto> getPictureDtoList() {
        return pictureDtoList;
    }

    public void setPictureDtoList(List<PictureDto> pictureDtoList) {
        this.pictureDtoList = pictureDtoList;
    }
}
