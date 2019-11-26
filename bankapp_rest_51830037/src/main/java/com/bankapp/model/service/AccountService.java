package com.bankapp.model.service;

import java.util.List;




import com.bankapp.model.entities.Account;


public interface AccountService {
	
	 public List<Account> getAllAccounts();
	 public void createAccount(Account account);
	 Account addAccount(Account account);
	 public void deleteAccount(Long id);
     public void blockAccount(Long accountNumber);
     public void deposit(Long accountNumber,Double amount);
     public void withdraw(Long accountNumber,Double amount);
     public void transfer(Long fromAccNumber,Long toAccNumber,Double amount);
     public Account findById(Long id);
     Account updateAccount(Long id,Account account);
   
}
