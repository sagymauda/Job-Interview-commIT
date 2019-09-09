package com.interviewtest.CommITJavaInterviewTest.service;


import com.interviewtest.CommITJavaInterviewTest.model.Quote;

import java.util.Optional;

public interface QuoteSerive {

    public Iterable<Quote> getAllQuots();

    public Optional<Quote> getQuote(Long id);

    public void createQoute(Quote quote);

    public void  updateQoute(Long id ,Quote quote);

    public void deleteSoftQoute(Long id);



}
