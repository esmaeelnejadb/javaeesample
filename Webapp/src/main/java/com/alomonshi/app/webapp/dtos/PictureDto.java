package com.alomonshi.app.webapp.dtos;

import javax.validation.constraints.NotNull;

public class PictureDto {

    private Integer id;

    @NotNull
    private String pictureURLList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPictureURLList() {
        return pictureURLList;
    }

    public void setPictureURLList(String pictureURLList) {
        this.pictureURLList = pictureURLList;
    }
}
