package com.hemanthworks.expenseTracker.datamodels;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Expense
{
	@Id
	private String name;

	private long amount;

	private String date;

	public String getName ()
	{
		return name;
	}

	public void setName ( String name )
	{
		this.name = name;
	}

	public long getAmount ()
	{
		return amount;
	}

	public void setAmount ( long amount )
	{
		this.amount = amount;
	}

	public String getDate ()
	{
		return date;
	}

	public void setDate ( String date )
	{
		this.date = date;
	}

}
