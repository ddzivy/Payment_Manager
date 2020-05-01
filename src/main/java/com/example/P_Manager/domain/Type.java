package com.example.P_Manager.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Type {
	//Defining attributes of Type entity
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long typeid;
	private String name;
	
	// Making type as a key that will be used in Payment object
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
	@JsonIgnore
	private List<Payment> payments;
	
	// Creating empty Type object
	public Type() {}
	
	// Creating Type object with attribute name; typeid is added automatically
	public Type(String name) {
		super();
		this.name = name;
	}

// Getters and setters for all attributes
	public Long getTypeid() {
		return typeid;
	}
	
	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	// Overriding method toString()
	@Override
	public String toString() {
		return "Type [typeid=" + typeid + ", name=" + name + "]";
	}
}
