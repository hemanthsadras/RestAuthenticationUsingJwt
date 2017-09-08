package com.hemanthworks.expenseTracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hemanthworks.expenseTracker.datamodels.Expense;
import com.hemanthworks.expenseTracker.repositories.ExpenseRepository;

@Service
public class ExpenseService
{
	@Autowired
	private ExpenseRepository expenseRepository;
	
	public Expense getExpense()
	{
		return expenseRepository.findOne("Ola Cabs");
	}
	
	public Expense addExpense(Expense expense)
	{
		return expenseRepository.save(expense); 
	}
}
