package com.bankapp.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.bankapp.model.entities.Account;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.controller.requests.DepositRequest;
import com.bankapp.web.controller.requests.TransferRequest;
import com.bankapp.web.controller.requests.WithdrawRequest;
@RestController
@RequestMapping(path="/api")
public class AccountTxController {

	@Autowired
	private AccountService accountService;
	
	/*@PostMapping(path = "account/deposit/{accountNumber}/{amount}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Account> deposit(@PathVariable(name="accountNumber")Long accountNumber,@PathVariable
			(name="amount")Double amount){
		  accountService.deposit(accountNumber, amount);
				return new ResponseEntity<Account>(HttpStatus.OK);
		
	}*/
	
	
	@PostMapping(path="/transaction/deposit")
	private ResponseEntity<Void> deposit(@RequestBody DepositRequest req, Principal principal){
		accountService.deposit(req.getAccountNumber(), req.getAmount());
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	/*@PostMapping(path = "account/withdraw/{accountNumber}/{amount}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Account> withdraw(@PathVariable(name="accountNumber")Long accountNumber,@PathVariable
			(name="amount")Double amount){
		  accountService.withdraw(accountNumber, amount);
				return new ResponseEntity<Account>(HttpStatus.OK);
		
	}*/
	@PostMapping(path="/transaction/withdraw")
	private ResponseEntity<Void> withdraw(@RequestBody WithdrawRequest req, Principal principal){
		accountService.withdraw(req.getAccountNumber(), req.getAmount());
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PostMapping(path="/transaction/transfer")
	private ResponseEntity<Void> transfer(@RequestBody TransferRequest req, Principal principal){
		accountService.transfer(req.getFromAccNumber(),req.getToAccNumber(), req.getAmount());
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	

	
	/*@PostMapping(path = "account/transfer/{fromAccNumber}/{toAccNumber}/{amount}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Account> transfer(@PathVariable(name="fromAccNumber")Long fromAccNumber,@PathVariable
			(name="toAccNumber")Long toAccNumber,@PathVariable(name="amount") Double amount){
		  accountService.transfer( fromAccNumber,toAccNumber,amount);
				return new ResponseEntity<Account>(HttpStatus.OK);
		
	}*/
	
	
	
	
	
}
