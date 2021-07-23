package com.alomonshi.app.service.user.enums;

public enum  ContactType {

    MOBILE_PHONE(1),
    HOME_PHONE(2),
    OFFICE_HOME(3),
    HOME_ADDRESS(4),
    OFFICE_ADDRESS(5),
    EMAIL(6),
    POSTAL_CODE(7);

    private Integer code;

    ContactType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
