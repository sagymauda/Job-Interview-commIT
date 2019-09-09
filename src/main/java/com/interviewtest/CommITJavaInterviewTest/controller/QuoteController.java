package com.interviewtest.CommITJavaInterviewTest.controller;

import com.interviewtest.CommITJavaInterviewTest.model.Quote;
import com.interviewtest.CommITJavaInterviewTest.service.QuoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quote")
public class QuoteController {


    @Autowired
    private QuoteServiceImpl quoteService;

    @GetMapping("/all")
    public List<Quote> getAllQuoats(){
        List<Quote>quotes = quoteService.getAllQuots();
        System.out.println(quotes.size());
        return quotes;
    }

    @GetMapping("/{id}")
    public Optional<Quote> getQuoatById(@PathVariable(value="id") Long id){
        Optional<Quote> quote = quoteService.getQuote(id);
        return quote;

    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void createQuote(@RequestBody Quote quote){
        quoteService.createQoute(quote);

    }

  @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void softDeleteQuote(@PathVariable(value="id") Long id){
        quoteService.deleteSoftQoute(id);

    }

    @PostMapping("/update/{id}")
    public void updateQoute(@PathVariable(value="id") Long id,@RequestBody Quote quote){
        quoteService.updateQoute(id,quote);
    }


}
