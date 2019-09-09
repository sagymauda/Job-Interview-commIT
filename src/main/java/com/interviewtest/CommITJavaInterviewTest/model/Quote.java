package com.interviewtest.CommITJavaInterviewTest.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;

    private Integer price;

    @JsonIgnore
    private Boolean isDeleted = false;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quote")
    private List<Item> itemsList = new ArrayList<>();


    public Quote() {

    }

    public Quote(String name, Integer price, List<Item> itemsList) {
        this.name = name;
        this.price = price;
        this.itemsList = itemsList;
    }



}
