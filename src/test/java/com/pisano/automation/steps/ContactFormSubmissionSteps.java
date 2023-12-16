package com.pisano.automation.steps;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.pisano.automation.hooks.Helper;
import com.pisano.automation.hooks.TestHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;


public class ContactFormSubmissionSteps {
    private static final Logger logger = LoggerFactory.getLogger(ContactFormSubmissionSteps.class);
    FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
    Locale locale = new Locale("tr");
    Faker faker = new Faker(locale);
    Helper helper = new Helper();

    @When("Email field is filled in")
    public void fillEmail() {
        TestHooks.driver.findElement(By.id("45be6d13-e704-4167-af03-1c6cf2d2b324")).sendKeys(fakeValuesService.bothify("????##@gmail.com"));
        logger.info("The required input is filled in the email section.");

    }
    @And("Name field is filled in")
    public void fillName(){
        TestHooks.driver.findElement(By.id("08f93e5a-4b2b-4e06-8468-f32586ed3ca1")).sendKeys((fakeValuesService.regexify("[a-z]{6}")));
        logger.info("The required input is filled in the name section ");


    }
    @And("Country Code button is clicked")
    public void clickCountryCodeBtn() throws InterruptedException {
        Thread.sleep(1000);
        TestHooks.driver.findElement(By.className("selected-flag")).click();
        logger.info("Country Code button is clicked");

    }
    @And("Verify the Country code container with {string} placeholder text")
    public void verifyCountryCodeContainer(String expectedText){
        logger.info("Country code pop up is verified");
        WebElement actualPlaceHolerElement = TestHooks.driver.findElement(By.xpath("(//span[normalize-space()='Afghanistan'])"));
        String actualText = actualPlaceHolerElement.getText();
        Assert.assertEquals(expectedText,actualText);

    }
    @And("Country Code is Searched with {string}")
    public void searchCountryCode(String phoneNumberCountry){
        TestHooks.driver.findElement(By.className("search-box"));
        TestHooks.driver.findElement(By.xpath("(//input[@placeholder='Enter a valid phone number including area code'])[1]")).sendKeys(phoneNumberCountry);
        logger.info("Country Code is Searched as Turkey");

    }
    @And("Country Code is Selected")
    public void selectCountryCode(){
        TestHooks.driver.findElement(By.xpath("((//li[@role='option'])[195])")).click();
        logger.info("Country Code is Selected as Turkey");
    }
    @And("Phone Number is Filled")
    public void fillPhoneNo(){
        TestHooks.driver.findElement(By.xpath("//input[@type='tel'] ")).sendKeys(faker.numerify("532+###-##-##"));
        logger.info("The required input is filled in the phone number section");



    }
    @And("Submit button is clicked")
    public void clickBtnSubmit() throws InterruptedException {
        TestHooks.driver.findElement(By.id("4d805800-70e6-4417-8c31-63b5f9b54e99")).click();
        logger.info("Submit button is clicked to send the form");
        Thread.sleep(3000);

    }
    @And("See the {string} message")
    public void successMessage(String expectedMessage){
        WebElement actualMessageElement = TestHooks.driver.findElement(By.xpath("//div[@class='component']"));
        helper.verifyElement(expectedMessage,actualMessageElement);
        logger.info("Feedback form submission is succesful");

    }
    @Then("Page is Refreshed")
    public void refreshPage(){
        TestHooks.driver.navigate().refresh();
        logger.info("Page is refreshed to return to the begining of test");
    }
    }


