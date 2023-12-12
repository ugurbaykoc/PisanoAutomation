package com.pisano.automation.steps;

import com.pisano.automation.hooks.TestHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LaunchingWidgetSteps {
    private static final Logger logger = LoggerFactory.getLogger(LaunchingWidgetSteps.class);
    @When("Switched to iframe")
    public void switchToIframe(){
        WebElement pisanoIframe = TestHooks.driver.findElement(By.xpath("//iframe[@id='psn-widget-button-frame']"));
        TestHooks.driver.switchTo().frame(pisanoIframe);
        logger.info("Focus changed to Iframe");
    }
    @And("Click to widget button")
    public void clickToWidgetButton()  {
        logger.info("The widget button was clicked on the Pisano test page");
        TestHooks.driver.findElement(By.xpath("(//div[@class='widget-button']//div)[2]")).click();
        logger.info("The widget window is opened");
    }

}
