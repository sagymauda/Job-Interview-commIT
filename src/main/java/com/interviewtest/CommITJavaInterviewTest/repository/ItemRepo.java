package com.interviewtest.CommITJavaInterviewTest.repository;

import com.interviewtest.CommITJavaInterviewTest.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepo extends CrudRepository<Item,Long> {

}
