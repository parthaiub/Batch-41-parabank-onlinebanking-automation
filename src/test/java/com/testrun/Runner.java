package com.testrun;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    plugin = {"json:target/cucumber.json"},
    features = {//"/Users/parthadebnath/eclipse-Batch-41/parabank-onlinebanking-automation/src/main/resources/Login.feature",
    		//"/Users/parthadebnath/eclipse-Batch-41/parabank-onlinebanking-automation/src/main/resources/ParabankLoginInvalidMultipleCredential.feature",
    		"/Users/parthadebnath/eclipse-Batch-41/parabank-onlinebanking-automation/src/main/resources/ParabankLoginValidMultipleCredential.Feature"},
    //{"src/main/resources/Login.feature"}, // Ensure the path is correct
    glue = {"com.generic"}, // Ensure step definitions are in the 'com.generic' package
    tags = "@Smoke and @Positive", // Correct tag syntax
    dryRun = false,
    monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void setup1() {
        // Add setup logic if needed
    }

    @BeforeTest
    public void setup2() {
        // Add setup logic if needed
    }
}
