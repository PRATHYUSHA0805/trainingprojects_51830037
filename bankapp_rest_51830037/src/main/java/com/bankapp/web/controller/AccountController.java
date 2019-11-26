package com.bankapp.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.service.AccountService;

@RestController
@RequestMapping(path="/api")
public class AccountController {

	@Autowired
	private AccountService accountService;
	


@GetMapping(path = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<Account>> getAllAccounts() {
	return new ResponseEntity<List<Account>>(accountService.getAllAccounts(), HttpStatus.OK);
}
@GetMapping(path = "/account/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Account> getAnaccount(@PathVariable(name = "id") Long id) {
	//Account account = accountService.findById(id);
	return new ResponseEntity<Account>(accountService.findById(id), HttpStatus.OK);

}

@DeleteMapping(path = "/account/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Void> deleteAccount(@PathVariable(name = "id") Long id) {
	accountService.deleteAccount(id);
	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
}

@PostMapping(path = "/account", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Account> addAccount(@Valid @RequestBody Account account) {
	return new ResponseEntity<Account>(accountService.addAccount(account), HttpStatus.CREATED);
}

@PutMapping(path = "/account/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Account>updateAccount(@PathVariable(name = "id") Long id, @RequestBody Account account) {
	accountService.updateAccount(id, account);
	return new ResponseEntity<Account>(accountService.updateAccount(id, account), HttpStatus.OK);
}


}
