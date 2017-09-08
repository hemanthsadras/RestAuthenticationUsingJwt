package com.hemanthworks.expenseTracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hemanthworks.expenseTracker.datamodels.Expense;
import com.hemanthworks.expenseTracker.services.ExpenseService;

@RestController
public class ExpenseController
{
	@Autowired
	private ExpenseService expenseService;
	
	@RequestMapping(method = RequestMethod.GET, value ="/greetings")
	public String sayHello()
	{
		return "hello from my application with secure API end point";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "expenses")
	public Expense getExpense()
	{
		return expenseService.getExpense();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/expense")
	public Expense addExpense(@RequestBody Expense expense)
	{
		return expenseService.addExpense(expense);
	}
}
