package org.example.definitionSteps;

import clients.RestClient;
import clients.WireMockClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.TestExecutionException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import utils.session.Session;

import static utils.TestUtil.invalidateParam;
import static utils.session.SessionKey.STUB_REQUEST;
import static utils.session.SessionKey.STUB_RESPONSE;


public class WireMockSteps {

    @Autowired
    private WireMockClient wireMockClient;
    @Autowired
    private Session session;
    @Autowired
    ObjectMapper objectMapper;

    @SneakyThrows
    @Given("wiremock stub is set for {requestType} request with {string} URL")
    public void initializeWireMockStub(RestClient.RequestTypes requestType, String url) {
        try {
            String requestBody = invalidateParam(objectMapper.writeValueAsString(session.get(STUB_REQUEST)));
            String responseBody = invalidateParam(objectMapper.writeValueAsString(session.get(STUB_RESPONSE)));

            wireMockClient.publishMapping(requestType, url, requestBody, responseBody);
        } catch (JsonProcessingException exception) {
            throw new TestExecutionException(exception.getMessage());
        }

    }

    @Then("wiremock stub received {requestType} request with {string} URL")
    public void verifyStub(RestClient.RequestTypes requestType, String url){
        wireMockClient.verifyMapping(requestType, url, 1);
    }
}
