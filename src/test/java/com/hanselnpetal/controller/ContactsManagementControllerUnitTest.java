package com.hanselnpetal.controller;

import com.hanselnpetal.domain.CustomerContact;
import com.hanselnpetal.service.ContactsManagementService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactsManagementController.class)
public class ContactsManagementControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactsManagementService contactsManagementService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddContactHappyPath() throws Exception {
        CustomerContact mockCustomerContact = new CustomerContact();
        mockCustomerContact.setFirstName("Faisal");
        mockCustomerContact.setLastName("Nisar");
        mockCustomerContact.setEmail("faisal.nisar@myemail.com");

        when(contactsManagementService.add(any(CustomerContact.class)))
                .thenReturn(mockCustomerContact);

        CustomerContact aContact = new CustomerContact();
        aContact.setFirstName("Faisal");
        aContact.setLastName("Nisar");
        aContact.setEmail("faisal.nisar@myemail.com");

        mockMvc.perform(post("/addContact", aContact))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testAddContactBizServiceRulesNotSatisfied() throws Exception {
        when(contactsManagementService.add(any(CustomerContact.class)))
                .thenReturn(null);
        CustomerContact contact = new CustomerContact();
        contact.setFirstName("faisal");

        mockMvc.perform(post("/addContact", null))
                .andExpect(status().is(null))
                .andReturn();
    }
}
