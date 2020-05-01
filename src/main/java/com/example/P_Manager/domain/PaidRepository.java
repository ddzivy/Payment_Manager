package com.example.P_Manager.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

// Public crud repository of Paid payments
public interface PaidRepository extends CrudRepository<Paid, Long> {
	List<Paid> findByName(String name);
}