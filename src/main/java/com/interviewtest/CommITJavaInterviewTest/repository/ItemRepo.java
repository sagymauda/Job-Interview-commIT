package com.interviewtest.CommITJavaInterviewTest.repository;

import com.interviewtest.CommITJavaInterviewTest.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends CrudRepository<Item,Long> {

}
