package com.example.P_Manager;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.P_Manager.domain.Type;
import com.example.P_Manager.domain.Paid;
import com.example.P_Manager.domain.PaidRepository;

@RunWith(SpringRunner.class)
@DataJpaTest

// Tests are limited because in the beginning PaidRepository does not store any data
public class PaidRepositoryTest {

    @Autowired
    private PaidRepository prrepository;

    //Test create new paid
    @Test
    public void createNewPaid() {
    	Paid paid = new Paid("National Bank", "PM0000555777", "1527€", "2020-08-17", new Type("Penalty"));
    	prrepository.save(paid);
    	assertThat(paid.getId()).isNotNull();
    }    
}