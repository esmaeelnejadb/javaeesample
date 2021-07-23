package com.alomonshi.app.webapp.dtos.response;

public class ErrorMessage {
    private Integer messageId;
    private Integer message;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }
}
