package com.pisano.automation.hooks;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Duration;

public class TestHooks {
    public static BROWSER browserType = BROWSER.CHROME;

    public enum BROWSER {
        CHROME,
        FIREFOX,
        EDGE,
        SAFARI

    }

    private static final Logger logger = LoggerFactory.getLogger(TestHooks.class);
    public static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        logger.info("Test starts...");
        switch (browserType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--disable-notifications");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications");
                driver = new EdgeDriver(edgeOptions);
            case SAFARI:
                SafariOptions safariOptions = new SafariOptions();
                driver = new SafariDriver(safariOptions);
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @AfterStep
    public void as(Scenario scenario) throws IOException, InterruptedException {
        if (scenario.isFailed()) {
            scenario.attach(Screenshot.getByteScreenshot(), "image/png", "screenshot");
        }
    }
        @AfterAll
        public static void afterAll() {
            driver.quit();
            logger.info("Test ends.");
        }
    }

