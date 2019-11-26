package com.bankapp.model.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
@Entity
@Table(name="accounttx_table")
public class AccountTransaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private LocalDateTime timeStamp;
  private String type;
  private double amount;
   @ManyToOne
  private Account account;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public LocalDateTime getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(LocalDateTime timeStamp) {
	this.timeStamp = timeStamp;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public Account getAccount() {
	return account;
}
public void setAccount(Account account) {
	this.account = account;
}
public AccountTransaction(String type, double amount) {
	super();
	this.timeStamp = LocalDateTime.now();
	this.type = type;
	this.amount = amount;

}
public AccountTransaction() {
	
}

  
  
  
}
