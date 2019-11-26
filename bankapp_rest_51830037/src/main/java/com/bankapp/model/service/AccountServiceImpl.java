package com.bankapp.model.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransaction;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.AccountTransactionRepository;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.repo.TransactionLogRepository;
import com.bankapp.model.service.exceptions.AccountNotFoundException;
import com.bankapp.model.service.exceptions.NotSufficientFundException;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountTransactionRepository accountTransactionRepository;
	
	@Autowired
	private TransactionLogRepository transactionLogRepository;

	@Override
	public void blockAccount(Long accountNumber) {
		
		
	}

	@Override
	public void createAccount(Account account) {
	  accountRepository.save(account);
	  customerRepository.save(account.getCustomer());
	}

	@Override
	public void deposit(Long accountNumber, Double amount) {
	  Account account=accountRepository.findById(accountNumber)
			     .orElseThrow(AccountNotFoundException::new);
		account.setBalance(account.getBalance()+amount);
		accountRepository.save(account);
		
		AccountTransaction accountTransaction=new AccountTransaction("deposit",amount);
		account.addAccountTransaction(accountTransaction);
		accountTransactionRepository.save(accountTransaction);
		
		TransactionLog log=new TransactionLog
				(accountNumber, null, "deposit", amount, "vyshu", "done");
		transactionLogRepository.save(log);
		
	}

	@Override
	public void withdraw(Long accountNumber, Double amount) {
		 Account account=accountRepository.findById(accountNumber)
			     .orElseThrow(AccountNotFoundException::new);
		 if(account.getBalance()-amount < 1000)
			 throw new NotSufficientFundException();
		 account.setBalance(account.getBalance()-amount);
			accountRepository.save(account); 
			
			AccountTransaction accountTransaction=new AccountTransaction("withdraw",amount);
			account.addAccountTransaction(accountTransaction);
			accountTransactionRepository.save(accountTransaction);
			
			TransactionLog log=new TransactionLog
					(accountNumber,null, "withdraw", amount, "naveeda", "done");
			transactionLogRepository.save(log);
		
	}

	@Override
	public void transfer(Long fromAccNumber, Long toAccNumber, Double amount) {
		 
		this.withdraw(fromAccNumber, amount);
		this.deposit(toAccNumber, amount);
		
		TransactionLog log=new TransactionLog
				(fromAccNumber, toAccNumber, "transfer", amount, "nandu", "done");
		transactionLogRepository.save(log);
		
		
	}

	@Override
	public List<Account> getAllAccounts() {
				return accountRepository.findAll();
	}

	@Override
	public Account addAccount(Account account) {
		
		return accountRepository.save(account);
	}

	@Override
	public void deleteAccount(Long id) {
	 accountRepository.deleteById(id);
		
	}
	@Override
	public Account findById(Long id) {
		return accountRepository.findById(id).orElseThrow(AccountNotFoundException::new);
	}

	@Override
	public Account updateAccount(Long id, Account account) {
		Account accountToBeUpdate = accountRepository.findById(id).orElseThrow(AccountNotFoundException::new);
		 accountToBeUpdate.setCustomer(account.getCustomer());
		 
		return accountRepository.save( accountToBeUpdate);
	}

	
	
}
