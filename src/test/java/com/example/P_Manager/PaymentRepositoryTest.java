package com.example.P_Manager;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.P_Manager.domain.Type;
import com.example.P_Manager.domain.Payment;
import com.example.P_Manager.domain.PaymentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository prepository;

    //Test find payment for: Table.oy
    @Test
    public void findByNameShouldReturnIBAN() {
        List<Payment> payments = prepository.findByName("Table.oy");
        assertThat(payments).hasSize(1);
        assertThat(payments.get(0).getIBAN()).isEqualTo("PM0009874321");
    }
    
    //Test create new payment
    @Test
    public void createNewPayment() {
    	Payment payment = new Payment("Central Bank", "PM0206597013", "10000€", "2020-12-31", new Type("Penalty"));
    	prepository.save(payment);
    	assertThat(payment.getId()).isNotNull();
    }    
    
    //Test delete payment for: Peter Smith
    @Test
    public void deletePayment() {
    	List <Payment> payments = prepository.findByName("Peter Smith");
    	prepository.deleteById(payments.get(0).getId());
    	assertThat(payments.isEmpty());
    }    
}