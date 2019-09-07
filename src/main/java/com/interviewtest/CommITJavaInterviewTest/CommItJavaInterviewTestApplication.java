package com.interviewtest.CommITJavaInterviewTest;

import com.interviewtest.CommITJavaInterviewTest.model.Item;
import com.interviewtest.CommITJavaInterviewTest.model.Quote;
import com.interviewtest.CommITJavaInterviewTest.repository.QuoteRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class CommItJavaInterviewTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommItJavaInterviewTestApplication.class, args);
	}
		@Bean
		public CommandLineRunner demo (QuoteRepo quoteRepo ) {
			return (args) -> {
				Item book =  new Item("book");
				Item pen =  new Item("pen");
				Item fork =  new Item("fork");
				Item sunGlasses =  new Item("sunGlasses");

				List<Item> itemsListOfQoute1 = new ArrayList<>();
				List<Item> itemsListOfQoute2 = new ArrayList<>();

				itemsListOfQoute1.add(book);
				itemsListOfQoute1.add(pen);
				itemsListOfQoute2.add(fork);
				itemsListOfQoute2.add(sunGlasses);

				Quote quote1 = new Quote("deal1",30,itemsListOfQoute1);
				Quote quote2 = new Quote("deal2",20,itemsListOfQoute2);
				quoteRepo.save(quote1);
				quoteRepo.save(quote2);













			};
		}

	}



