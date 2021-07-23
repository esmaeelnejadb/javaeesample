package com.alomonshi.app.webapp.dtos;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class CompanyDto {
    private Integer id;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String name;

    private Boolean active;


    private List<PictureDto> pictureDtoList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
