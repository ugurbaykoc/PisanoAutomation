package com.pisano.automation.steps;

import com.pisano.automation.hooks.TestHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigationSteps {
    private static final Logger logger = LoggerFactory.getLogger(NavigationSteps.class);

    @Given("I navigate to {string}")
    public void givenUrl(String url) {
        TestHooks.driver.navigate().to(url);
        logger.info("Pisano test page opened.");


    }

    @Then("I should see the {string} is opened")
    public void checkUrl(String expectedUrl) {
        String currentUrl = TestHooks.driver.getCurrentUrl();
        assertEquals(expectedUrl, currentUrl);
        logger.info("Main page url is verified");
        logger.info("I see the Pisano test page opened when I go to the given url");
    }

}
