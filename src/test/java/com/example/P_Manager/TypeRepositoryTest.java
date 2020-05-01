package com.example.P_Manager;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.P_Manager.domain.Type;
import com.example.P_Manager.domain.TypeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TypeRepositoryTest {

    @Autowired
    private TypeRepository trepository;
    
    //Test find type: product
    @Test
    public void findByNameShouldReturnId() {
        List<Type> types = trepository.findByName("Product");
        assertThat(types).hasSize(1);
        assertThat(types.get(0).getTypeid()).isEqualTo(1);
    }
    
    //Test create new type
    @Test
    public void createNewType() {
    	Type type = new Type("Fee");
    	trepository.save(type);
    	assertThat(type.getTypeid()).isNotNull();
    }    
    
    //Test delete type: refund
    @Test
    public void deleteType() {
    	List <Type> types = trepository.findByName("Refund");
    	trepository.deleteById(types.get(0).getTypeid());
    	assertThat(types.isEmpty());
    } 
}