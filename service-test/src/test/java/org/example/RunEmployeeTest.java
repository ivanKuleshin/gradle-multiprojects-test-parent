package org.example;

// mvn clean test -Dcucumber.filter.tags="@employee"
// to run this class with different tags

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/getAllEmployees.feature",
        glue = {"org.example"},
        tags = "(@employee or @test) and not @ignore")
public class RunEmployeeTest {

}
