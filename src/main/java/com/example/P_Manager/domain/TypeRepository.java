package com.example.P_Manager.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

//Public crud repository of Types
public interface TypeRepository extends CrudRepository<Type, Long> {
    List<Type> findByName(String name);
}
