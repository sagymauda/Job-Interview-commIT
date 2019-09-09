package com.interviewtest.CommITJavaInterviewTest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JsonIgnore
    private Quote quote;

    public Quote getQuote() {
        return quote;
    }

    public Item(String name) {
        this.name = name;

    }

    public Item() {
    }


}
