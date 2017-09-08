package com.hemanthworks.expenseTracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hemanthworks.expenseTracker.datamodels.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount,String>
{
	UserAccount findByUsername(String username);
}
