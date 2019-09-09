package com.interviewtest.CommITJavaInterviewTest.service;


import com.interviewtest.CommITJavaInterviewTest.model.ErrorMessageType;
import com.interviewtest.CommITJavaInterviewTest.model.Operation;
import com.interviewtest.CommITJavaInterviewTest.model.Quote;
import com.interviewtest.CommITJavaInterviewTest.model.QuoteLog;
import com.interviewtest.CommITJavaInterviewTest.repository.QuoteRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class QuoteServiceImpl implements QuoteService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QuoteLogService quoteLogService;


    @Autowired
    private QuoteRepo quoteRepo;

    @Override
    public List<Quote> getAllQuotes() {
        return quoteRepo.findAllByIsDeletedFalse();
    }

    @Override
    public Optional<Quote> getQuote(Long id) {
        return quoteRepo.findById(id);
    }

    @Override
    public void createQuote(Quote quote) {
        if (!isValidName(quote)) {
            logger.error(ErrorMessageType.NULL_INPUT.toJson());
            return;
        }
        if (!isValidPrice(quote)) {
            logger.error(ErrorMessageType.ILLIGAL.toJson());
            return;
        }

        quoteRepo.save(quote);
        QuoteLog quoteLog = new QuoteLog(new Date(),quote.getId(), Operation.CREATE,0,"The Quote Has Been Saved");
        quoteLogService.Create(quoteLog);

    }

    @Override
    public void updateQuote(Long id, Quote quote) {
        Optional<Quote> optionalQuote = quoteRepo.findById(id);

        if (optionalQuote.isPresent()) {
            Quote exsistQuote = optionalQuote.get();

            if (!isValidName(quote)) {
                logger.error(ErrorMessageType.NULL_INPUT.toJson());
                return;
            }
            if (!isValidPrice(quote)) {
                logger.error(ErrorMessageType.ILLIGAL.toJson());
                return;
            }

            exsistQuote.setName(quote.getName());
            exsistQuote.setPrice(quote.getPrice());
            exsistQuote.setItemsList(quote.getItemsList());
            quoteRepo.save(exsistQuote);
            QuoteLog quoteLog = new QuoteLog(new Date(),id, Operation.UPDATE,0,"The Quote Has Been Updated");
            quoteLogService.Create(quoteLog);
        }
    }


    @Override
    public void deleteSoftQuote(Long id) {
        Optional<Quote> optionalQuote = quoteRepo.findById(id);

        if (optionalQuote.isPresent()) {
            Quote exsistQuote = optionalQuote.get();
            exsistQuote.setIsDeleted(true);

            quoteRepo.save(exsistQuote);

            QuoteLog quoteLog = new QuoteLog(new Date(),id, Operation.DELETE,0,"The Quote Has Been SOFT Deleted");
            quoteLogService.Create(quoteLog);
        }
    }

    private boolean isValidName(Quote quote) {
        return (quote.getName() != null);
    }

    private boolean isValidPrice(Quote quote) {
        return (quote.getPrice() != null && quote.getPrice() > 0);
    }

}
