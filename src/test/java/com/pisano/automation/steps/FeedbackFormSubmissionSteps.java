package com.pisano.automation.steps;

import com.pisano.automation.hooks.Helper;
import com.pisano.automation.hooks.TestHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class FeedbackFormSubmissionSteps {
    private static final Logger logger = LoggerFactory.getLogger(FeedbackFormSubmissionSteps.class);
    Helper helper = new Helper();
    @When("Switched to Iframe content")
public void switchToIframeContent(){
        TestHooks.driver.switchTo().parentFrame();
        WebElement pisanoIframeContent = TestHooks.driver.findElement(By.xpath("//iframe[@id='psn-widget-content-frame']"));
        TestHooks.driver.switchTo().frame(pisanoIframeContent);
        logger.info("Focus changed to Iframe Content");
}
    @And("Select random satisfactory score")
    public void selectRandomSatisfactoryScore(){
        List<WebElement> scores = TestHooks.driver.findElements(By.xpath("(//div[@class='button button--nps']/following-sibling::div)"));
        helper.selectRandomElement(scores);
        logger.info("Satisfactory Score is selected");
    }
    @And("Select random Sentiment")
    public void selectRandomSentiment() throws InterruptedException {
        Thread.sleep(200);
        List<WebElement> sentiments = TestHooks.driver.findElements(By.xpath("//div[@id='def2c931-c3b3-4ea5-a142-b7ae3c44c3fc']"));
        helper.selectRandomElement(sentiments);
        logger.info("Sentiment is selected");
    }
    @Then("Next Step button is clicked to proceed to next step")
    public void clickBtnNextStep(){
        TestHooks.driver.findElement(By.id("1f30269f-7aa9-4c9c-b087-547422a389f4")).click();
        logger.info("Next Step button is clicked to perform proceed to Next Step action");
    }
    @Then("Message on the first page is verified with {string}")
    public void verifyMessageOnFirstPage(String expectedText){
        WebElement actualPlaceHolerElement = TestHooks.driver.findElement(By.xpath("((//div[contains(text(),'Would you recommend us to your friends and colleag')])[1])"));
        helper.verifyElement(expectedText,actualPlaceHolerElement);
        logger.info("Message on the first page is verified after Declining User Agreement");


    }
    }


