package com.hanselnpetal;

import com.hanselnpetal.controller.ContactsManagementControllerIntegrationTest;
import com.hanselnpetal.data.repos.CustomerContactRepositoryIntegrationTest;
import com.hanselnpetal.service.ContactsManagementServiceIntegrationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContactsManagementServiceIntegrationTest.class,
        CustomerContactRepositoryIntegrationTest.class
})
public class AddContactFeatureTestSuite {
    // intentionally empty - Test suite setup (annotations is sufficient)
}
