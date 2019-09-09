package com.interviewtest.CommITJavaInterviewTest.service;


import com.interviewtest.CommITJavaInterviewTest.model.Quote;

import java.util.Optional;

public interface QuoteService {

    public Iterable<Quote> getAllQuotes();

    public Optional<Quote> getQuote(Long id);

    public void createQuote(Quote quote);

    public void  updateQuote(Long id ,Quote quote);

    public void deleteSoftQuote(Long id);



}
