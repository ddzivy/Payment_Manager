package com.example.P_Manager.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

//Public crud repository of Persons
public interface PersonRepository extends CrudRepository<Person, Long> {
	Person findByUsername(String username);
	List<Person> findByEmail(String email);
}
