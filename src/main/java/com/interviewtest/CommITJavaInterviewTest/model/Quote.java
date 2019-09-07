package com.interviewtest.CommITJavaInterviewTest.model;


import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,unique = true)
    private String name;

    private Integer price;

   @OneToMany(cascade=CascadeType.ALL,mappedBy = "quote")
   private  List<Item> itemsList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NullPointerException {
        if(name!=null) {
            this.name = name;
        }else{
            throw new NullPointerException("the name cannot be null" );
        }
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) throws IllegalArgumentException {
        if (price > 0) {
            this.price = price;
        } else {
           throw new IllegalArgumentException("the price nneds to be bigger then zero");
        }

    }

    public List<Item> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public Quote() {

    }

    public Quote(String name, Integer price, List<Item> itemsList) {
        this.name = name;
        this.price = price;
        this.itemsList = itemsList;
    }


}
