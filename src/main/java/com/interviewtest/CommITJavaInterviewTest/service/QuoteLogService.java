package com.interviewtest.CommITJavaInterviewTest.service;

import com.interviewtest.CommITJavaInterviewTest.model.QuoteLog;
import com.interviewtest.CommITJavaInterviewTest.repository.QuoteLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteLogService {

    @Autowired
    private QuoteLogRepo quoteLogRepo;


    public void Create(QuoteLog quoteLog){
        quoteLogRepo.save(quoteLog);
    }
}
