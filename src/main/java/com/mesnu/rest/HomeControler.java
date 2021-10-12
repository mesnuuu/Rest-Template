package com.mesnu.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeControler {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/")
	public String home(Model model) {

		
		  Quote quote = restTemplate.getForObject(
		  "https://quoters.apps.pcfone.io/api/random", Quote.class);
		  
		  String quoteString = quote.getValue().getQuote();
		  
		  model.addAttribute("quote", quoteString) ;
		 

		return "home";

	}

}
