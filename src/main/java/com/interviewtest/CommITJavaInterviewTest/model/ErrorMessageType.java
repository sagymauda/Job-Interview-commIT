package com.interviewtest.CommITJavaInterviewTest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorMessageType {
    ALREADY_EXIST(1,"quote already exist "),
    NULL_INPUT(2,"the name cannot be null"),
    ILLIGAL(3,"the price ne" +
            "eds to be bigger then zero");

    private int errorCode;
    private String description;
    private String level = "error";

    public int getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }

    ErrorMessageType(int errorCode, String description) {
        this.description = description;
        this.errorCode=errorCode;
    }

    public String toJson() {
        try {
            return (new ObjectMapper()).writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
