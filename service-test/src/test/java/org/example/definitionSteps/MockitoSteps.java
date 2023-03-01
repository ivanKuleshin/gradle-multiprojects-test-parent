package org.example.definitionSteps;

import io.cucumber.java.en.Given;
import org.example.client.ExternalClient;
import org.example.model.Address;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import utils.TestUtil;
import utils.session.Session;

import static utils.session.SessionKey.EXPECTED_MOCK_ADDRESS;


public class MockitoSteps {

  @Autowired
  ExternalClient externalClient;
  @Autowired protected Session session;

  @Given("expected behaviour was set for ExternalClient.getEmployeeHash with '{int}' employeeId and expected {string} hash")
  public void setExpectedBehaviourForGetEmployeeHash(Integer employeeId, String expectedHash) {

//    Mockito.when(externalClient.getEmployeeHash(employeeId)).thenReturn(expectedHash);
    Mockito.doReturn(expectedHash).when(externalClient).getEmployeeHash(employeeId);
  }

  @Given("expected behaviour was set for ExternalClient.addAddress with '{int}' employeeId and Address entry:")
  public void setExpectedBehaviourForAddAddress(Integer employeeId, Address address) {
    Address expectedMockAddress =
        TestUtil.castMapToObject(session.get(EXPECTED_MOCK_ADDRESS), Address.class);

    Mockito.doReturn(expectedMockAddress).when(externalClient).addAddress(employeeId, address);
  }

  @Given("expected unsuccessful behaviour was set for ExternalClient.addAddress with '{int}' employeeId and Address entry:")
  public void setExpectedUnsuccessfulBehaviourForAddAddress(Integer employeeId, Address address) {
    Mockito.doThrow(new RuntimeException("Error during adding an address to Object"))
        .when(externalClient)
        .addAddress(employeeId, address);
  }

  @Given("reset all mocks")
  public void resetAllMocks() {
    Mockito.reset(externalClient);
  }
}
