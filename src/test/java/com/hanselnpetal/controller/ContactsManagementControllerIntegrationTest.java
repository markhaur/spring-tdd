package com.hanselnpetal.controller;

import com.hanselnpetal.domain.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactsManagementControllerIntegrationTest {

    @Autowired
    private ContactsManagementController contactsManagementController;

    @Test
    public void addContactHappyPathTest(){
        CustomerContact aContact = new CustomerContact();
        aContact.setFirstName("Faisal");
        aContact.setLastName("Nisar");
        aContact.setEmail("faisal.nisar@example.com");

        String output = contactsManagementController.processAddContactSubmit(aContact);

        assertEquals(output, "success");
    }
}
