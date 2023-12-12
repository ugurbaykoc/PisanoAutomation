package com.pisano.automation.steps;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.pisano.automation.hooks.TestHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Locale;

public class AgreementPageSteps {
    private static final Logger logger = LoggerFactory.getLogger(AgreementPageSteps.class);
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());
    @When("Conversation flow textbox is filled in")
    public void fillConversationFlowTextBox(){
        logger.info("Required input was filled in in conversation flow textbox ");
        TestHooks.driver.findElement(By.id("01edeca6-00da-4170-a33b-77364ed7de99")).sendKeys(fakeValuesService.regexify("[a-z1-9]{50}"));
    }
    @And("User agreement is accepted")
    public void acceptUserAgreement(){
        TestHooks.driver.findElement(By.xpath("(//div[@role='button'])[3]")).click();
        logger.info("Accept user agreement checkbox is clicked");

    }
    @And("User agreement is declined")
    public void declineUserAgreement(){
        TestHooks.driver.findElement(By.xpath("(//div[@role='button'])[4]")).click();
        logger.info("Decline user agreement checkbox is clicked");

    }
    @And("Favorite feedback tool is selected")
    public void selectFavTool(){
        TestHooks.driver.findElement(By.xpath("(//div[@role='button'])[5]")).click();
        logger.info("Favourite Feedback tool is selected");


    }

    @Then("Next Page button is clicked to proceed to next page action")
    public void clickBtnNextStep(){
        TestHooks.driver.findElement(By.id("5ef0f5ea-2495-435a-9cdd-11ea7f5f93b7")).click();
        logger.info("Next Page button is clicked ");
    }
}
