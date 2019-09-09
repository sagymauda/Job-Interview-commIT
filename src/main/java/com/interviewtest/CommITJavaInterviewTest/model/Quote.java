package com.interviewtest.CommITJavaInterviewTest.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.NamedQuery;
import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Entity
//@SQLDelete(sql = "UPDATE quote SET state ='DELETED' where id=?", check = ResultCheckStyle.COUNT)
//@Where(clause = "state <> 'DELETED'")
//@NamedQuery(name = "Quote.")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;

    private Integer price;


    @Column
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private QuoteState state;

    public QuoteState getState() {
        return state;
    }

    public void setState(QuoteState state) {
        this.state = state;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quote")
    private List<Item> itemsList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NullPointerException {
            this.name = name;

    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) throws IllegalArgumentException {
            this.price = price;


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

//    @PreRemove
//    public void deleteQuote() {
//        this.state = QuoteState.DELETED;
//    }

}
