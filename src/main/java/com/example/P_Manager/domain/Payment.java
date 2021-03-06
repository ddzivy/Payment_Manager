package com.example.P_Manager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Payment {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	// Defining attributes of Payment entity
	private Long id;
	private String name;
	private String IBAN;
	private String amount;
	private String date;
	
	// type is from entity Type and is one of the payment attribute, it is joined here
	@ManyToOne
	@JoinColumn(name = "typeid")
	private Type type;
	
	private String paid;
	
	// Creating empty Payment object
	public Payment() {}
    
	// Creating Payment object with attributes
	public Payment(String name, String IBAN, String amount, String date, Type type, String paid) {
		super();
		this.name = name;
		this.IBAN = IBAN;
		this.amount = amount;
		this.date = date;
		this.type = type;
		this.paid = paid;
	}

// Getters and setters for all attributes
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIBAN() {
		return IBAN;
	}
	public void setIBAN(String IBAN) {
		this.IBAN = IBAN;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getPaid() {
		return paid;
	}
	public void setPaid(String paid) {
		this.paid = paid;
	}
	
	// Overriding method toString()
	@Override
	public String toString() {
		if (this.type != null)
			return "Payment [id=" + id + ", name=" + name + ", IBAN=" + IBAN + ", amount=" + amount + ",date=" + date + " type =" + this.getType() + ", paid=" + paid + "]";		
		else
			return "Payment [id=" + id + ", name=" + name + ", IBAN=" + IBAN + ", amount=" + amount + ",date=" + date + ", paid=" + paid + "]";
	}
}