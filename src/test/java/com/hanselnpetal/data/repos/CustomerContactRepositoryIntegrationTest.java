package com.hanselnpetal.data.repos;

import com.hanselnpetal.domain.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase( replace = AutoConfigureTestDatabase.Replace.NONE )
public class CustomerContactRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CustomerContactRepository customerContactRepository;

    @Test
    public void testFindByEmail(){
        CustomerContact contact = new CustomerContact();
        contact.setEmail("json@xml.com");

        testEntityManager.persist(contact);

        CustomerContact foundContact = customerContactRepository.findByEmail("json@xml.com");

        assertEquals(foundContact.getEmail(), contact.getEmail());
    }
}
