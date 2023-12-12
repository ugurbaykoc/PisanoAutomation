package com.pisano.automation.steps;

import com.pisano.automation.hooks.TestHooks;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeclineUserAgreementSteps {
    private static final Logger logger = LoggerFactory.getLogger(DeclineUserAgreementSteps.class);
    @And("User agreement is declined")
    public void declineUserAgreement(){
        TestHooks.driver.findElement(By.xpath("(//div[@role='button'])[4]")).click();
        logger.info("Decline user agreement checkbox is clicked");

    }

}

