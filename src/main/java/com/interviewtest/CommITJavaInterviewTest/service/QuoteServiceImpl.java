package com.interviewtest.CommITJavaInterviewTest.service;


import com.interviewtest.CommITJavaInterviewTest.model.ErrorMessageType;
import com.interviewtest.CommITJavaInterviewTest.model.Quote;
import com.interviewtest.CommITJavaInterviewTest.repository.QuoteRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuoteServiceImpl implements QuoteSerive {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
        if (!isValidName(quote)) {
            logger.error(ErrorMessageType.NULL_INPUT.toJson());
            return;
        }
        if (!isValidPrice(quote)) {
            logger.error(ErrorMessageType.ILLIGAL.toJson());
            return;
        }
        quoteRepo.save(quote);
    }

    @Override
    public void updateQoute(Long id, Quote quote) {
        Optional<Quote> quote1 = quoteRepo.findById(id);
        if (!isValidName(quote)) {
            logger.error(ErrorMessageType.NULL_INPUT.toJson());
            return;
        }
        if (!isValidPrice(quote)) {
            logger.error(ErrorMessageType.ILLIGAL.toJson());
            return;
        }
        quote1.get().setName(quote.getName());
        quote1.get().setPrice(quote.getPrice());
        quote1.get().setItemsList(quote.getItemsList());
        quoteRepo.save(quote1.get());
    }


    @Override
    public void deleteSoftQoute(Long id) {
        Optional<Quote> quote = quoteRepo.findById(id);

        if (quote.isPresent()) {
            Quote quote1 = quote.get();
            quote1.

            quoteRepo.deleteById(id);
        }
    }

    private boolean isValidName(Quote quote) {
        return (quote.getName() != null);
    }

    private boolean isValidPrice(Quote quote) {
        return (quote.getPrice() != null && quote.getPrice() > 0);
    }

}
