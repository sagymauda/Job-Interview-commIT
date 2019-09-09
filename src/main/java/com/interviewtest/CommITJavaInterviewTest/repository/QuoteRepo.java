package com.interviewtest.CommITJavaInterviewTest.repository;


import com.interviewtest.CommITJavaInterviewTest.model.Quote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuoteRepo extends CrudRepository<Quote,Long> {
      List<Quote> findAll();
      List<Quote> findAllByIsDeletedFalse();






}
