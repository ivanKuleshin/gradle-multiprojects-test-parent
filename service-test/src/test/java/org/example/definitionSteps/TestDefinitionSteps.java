package org.example.definitionSteps;

import annotations.CucumberComponent;
import clients.RestClient;
import io.cucumber.java.en.Given;
import io.restassured.http.Method;
import org.springframework.beans.factory.annotation.Autowired;

@CucumberComponent
public class TestDefinitionSteps {

    @Autowired
    RestClient restClient;

    @Given("User performs test")
    public void test1() {
        System.out.println("User performs test");
        System.out.println("Test result: " + restClient.sendRequestWithoutParams(Method.GET, "/employee")
                .getBody().asPrettyString());
    }
}
