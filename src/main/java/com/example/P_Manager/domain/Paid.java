package com.example.P_Manager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Paid {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	// Defining attributes of Paid entity
	private Long id;
	private String name;
	private String IBAN;
	private String amount;
	private String date;
	
	// type is from entity Type and is one of the paid attribute, it is joined here
	//@ManyToOne
	//@JoinColumn(name = "typeid") 
	private String type;
	
	// Creating empty Paid object
	public Paid() {}
    
	// Creating Paid object with attributes
	public Paid(String name, String IBAN, String amount, String date, String type) {
		super();
		this.name = name;
		this.IBAN = IBAN;
		this.amount = amount;
		this.date = date;
		this.type = type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	// Overriding method toString()
	@Override
	public String toString() {
		//if (this.type != null)
		return "Paid [id=" + id + ", name=" + name + ", IBAN=" + IBAN + ", amount=" + amount + ",date=" + date + " type =" + type + "]";		
	//	else
	//		return "Paid [id=" + id + ", name=" + name + ", IBAN=" + IBAN + ", amount=" + amount + ",date=" + date + "]";
	}
}