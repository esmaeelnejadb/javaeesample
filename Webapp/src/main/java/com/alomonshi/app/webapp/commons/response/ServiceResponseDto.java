package com.alomonshi.app.webapp.commons.response;

import com.alomonshi.app.webapp.commons.message.ErrorMessage;

import javax.xml.crypto.Data;
import java.util.List;

public class ServiceResponseDto {
    private Data errorCode;
    private List<ErrorMessage> errorMessages;
    private Object data;

    public Data getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Data errorCode) {
        this.errorCode = errorCode;
    }

    public List<ErrorMessage> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<ErrorMessage> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
