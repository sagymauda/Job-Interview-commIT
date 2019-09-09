package com.interviewtest.CommITJavaInterviewTest.model;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "quote_log")
public class QuoteLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "create_date")
    private Date createdDate;
    @Column(name = "quote_id")
    private long quoteId;

    private Operation operation;

    private int errorCode;

    private String message;

    public QuoteLog() {
    }

    public QuoteLog(Date createdDate, long quoteId, Operation operation, int errorCode, String message) {
        this.createdDate = createdDate;
        this.quoteId = quoteId;
        this.operation = operation;
        this.errorCode = errorCode;
        this.message = message;
    }
}
