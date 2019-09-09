package com.interviewtest.CommITJavaInterviewTest.repository;

import com.interviewtest.CommITJavaInterviewTest.model.QuoteLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteLogRepo extends CrudRepository<QuoteLog,Long> {
}
