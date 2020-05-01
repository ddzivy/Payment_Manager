package com.example.P_Manager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
// Defining attributes of Person entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Each object will get unique id, that can not be changed
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    // Username with unique constraint; can not be null
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    // Password is stored as a BCrypt hash; can not be null
    @Column(name = "password", nullable = false)
    private String passwordHash;
    
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "role", nullable = false)
    private String role;
    
    // Creating empty Person object
    public Person() {
    }

    // Creating Person object
	public Person(String username, String passwordHash, String email, String role) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.email = email;
		this.role = role;
	}

// Getters and setters for all attributes
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
