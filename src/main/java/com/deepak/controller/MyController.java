package com.deepak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/home")
	public String home()
	{
		String home="Welcome to sdfc-bank home page";
		return home;
	}
	
	@GetMapping("/detail")
	public String details()
	{
		String detail="go to sdbc bank website you will find complete details";
		return detail;
	}
	@GetMapping("/balance")
	public String balance()
	{
		String balance="your current balance is 4000";
		return balance;
	}
	  
	@GetMapping("/statement")
	public String statement()
	{
		String statement="your statement is generated and sent to your corresponding mail id";
		return statement;
	}
	@GetMapping("/loan")
	public String loan()
	{
		String loan="loan facilities coming soon!...";
		return loan;
	}
	@GetMapping("/contact")
	public String contact()
	{
		String contact="any queries contact branch,online qvailable 24/7";
		return contact;
	}

}
