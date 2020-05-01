package com.example.P_Manager.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

// Public crud repository of Payments
public interface PaymentRepository extends CrudRepository<Payment, Long> {
	List<Payment> findByName(String name);
}