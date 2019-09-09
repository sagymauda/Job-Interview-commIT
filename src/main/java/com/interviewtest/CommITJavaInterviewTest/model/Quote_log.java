package com.interviewtest.CommITJavaInterviewTest.model;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Quote_log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date created_date;

    private long  quote_id;

    private Operation operation;

    private int errorcode;

    private String message;

    public Quote_log() {}

    public Quote_log(Date created_date, long quote_id, Operation operation, int errorcode, String message) {
        this.created_date = created_date;
        this.quote_id = quote_id;
        this.operation = operation;
        this.errorcode = errorcode;
        this.message = message;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public long getQuote_id() {
        return quote_id;
    }

    public void setQuote_id(long quote_id) {
        this.quote_id = quote_id;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Quote_log{" +
                "id=" + id +
                ", created_date=" + created_date +
                ", quote_id=" + quote_id +
                ", operation=" + operation +
                ", errorcode=" + errorcode +
                ", message='" + message + '\'' +
                '}';
    }
}
