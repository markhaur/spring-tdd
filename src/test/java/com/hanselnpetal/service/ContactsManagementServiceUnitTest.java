package com.hanselnpetal.service;

import com.hanselnpetal.data.repos.CustomerContactRepository;
import com.hanselnpetal.domain.CustomerContact;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.NONE )
public class ContactsManagementServiceUnitTest {

    @Mock
    private CustomerContactRepository customerContactRepository;

    @InjectMocks
    private ContactsManagementService contactsManagementService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddContactHappyPath(){
        // create a contact
        CustomerContact aContact = new CustomerContact();
        aContact.setFirstName("Faisal");
        aContact.setLastName("Nisar");
        aContact.setEmail("faisal.nisar@example.com");

        when(customerContactRepository.save(any(CustomerContact.class))).thenReturn(aContact);

        CustomerContact newContact = contactsManagementService.add(aContact);

        assertEquals("Faisal", newContact.getFirstName());
        assertEquals("Nisar", newContact.getLastName());
        assertEquals("faisal.nisar@example.com", newContact.getEmail());
    }


}
