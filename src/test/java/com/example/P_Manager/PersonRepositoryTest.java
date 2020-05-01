package com.example.P_Manager;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.P_Manager.domain.Person;
import com.example.P_Manager.domain.PersonRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository urepository;
    
    //Test find person: secretary
    @Test
    public void findByEmailShouldReturnUsername() {
        List<Person> users = urepository.findByEmail("secretary@pm.oy");
        assertThat(users).hasSize(1);
        assertThat(users.get(0).getUsername()).isEqualTo("secretary");
    }
    
    //Test create person: worker/worker
    @Test
    public void createNewPerson() {
    	Person user = new Person("worker", "$2a$10$krZB0AMe5ae/V4iE8ytW2.If/rUlUUjEpniVLyU051Wg2v.Z0g9dW", "worker@pm.oy", "USER");
    	urepository.save(user);
    	assertThat(user.getId()).isNotNull();
    }
    
    //Test delete person: manager
    @Test
    public void deletePerson() {
    	List <Person> users = urepository.findByEmail("manager@pm.oy");
    	urepository.deleteById(users.get(0).getId());
    	assertThat(users.isEmpty());
    } 
}