package com.hemanthworks.expenseTracker.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hemanthworks.expenseTracker.datamodels.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, String>
{

}
