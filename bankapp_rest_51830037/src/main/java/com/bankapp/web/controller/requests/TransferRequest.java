package com.bankapp.web.controller.requests;

public class TransferRequest {
  private Long fromAccNumber;
  private  Long toAccNumber;
  private Double amount;
  
public Long getFromAccNumber() {  
	return fromAccNumber;
}
public void setFromAccNumber(Long fromAccNumber) {
	this.fromAccNumber = fromAccNumber;
}
public Long getToAccNumber() {
	return toAccNumber;
}
public void setToAccNumber(Long toAccNumber) {
	this.toAccNumber = toAccNumber;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}
  
  
  
}
