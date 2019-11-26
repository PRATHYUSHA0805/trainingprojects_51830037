package com.bankapp.web.controller.requests;

public class DepositRequest {
  private Long AccountNumber;
  private Double amount;
  
public Long getAccountNumber() {
	return AccountNumber;
}
public void setAccountNumber(Long accountNumber) {
	AccountNumber = accountNumber;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}


  
}
