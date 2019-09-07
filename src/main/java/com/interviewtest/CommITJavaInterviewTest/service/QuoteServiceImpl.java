package com.interviewtest.CommITJavaInterviewTest.service;


import com.interviewtest.CommITJavaInterviewTest.model.Quote;
import com.interviewtest.CommITJavaInterviewTest.repository.QuoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuoteServiceImpl implements QuoteSerive {

    @Autowired
    private QuoteRepo quoteRepo;


    @Override
    public List<Quote> getAllQuots() {
        return quoteRepo.findAll();
    }

    @Override
    public Optional<Quote> getQuote(Long id) {
        return quoteRepo.findById(id);
    }

    @Override
    public void createQoute(Quote quote) {
        quoteRepo.save(quote);

    }

    @Override
    public void updateQoute(Quote quote) {

        Quote quote1 = new Quote();
        quote1.setName(quote.getName());
        quote1.setPrice(quote.getPrice());
        quote1.setItemsList(quote.getItemsList());
        quoteRepo.save(quote1);

    }


    @Override
    public void deleteSoftQoute(Quote quote) {
       quoteRepo.delete(quote);
    }
}
