package com.custapp.model.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "customer_table5")

public class Customer{
	@Id
	@GeneratedValue
	private int id;
	
	@NotEmpty(message="name cant left blank")
	private String name;
	
	@Email
	@NotEmpty(message="email cant left blank")
	private String email;
	
	@NotEmpty(message="phoneno cant left blank")
	private String phoneno;
	
	@NotEmpty(message="address cant left blank")
	private String address;
	

	@NotNull(message="salary can not be null")
	@Min(value=1000, message="salary should be more then 1000")
	private Double salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
	
	public Customer(String name, String email, String phoneno, String address, Double salary) {
		super();
		
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.address = address;
		this.salary = salary;
	}
	public Customer(){
		
	}
	
	
	
}
