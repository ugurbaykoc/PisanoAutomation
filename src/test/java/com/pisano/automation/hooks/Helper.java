package com.pisano.automation.hooks;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Helper
{

    public void selectRandomElement(List<WebElement> elements){
        if (!elements.isEmpty()) {
            int randomIndex = new Random().nextInt(elements.size());
            WebElement randomElement = elements.get(randomIndex);
            randomElement.click();
        } else {
            System.out.println("No elements found with the specified XPath.");
        }
    }
    public void verifyElement(String expectedText,WebElement elementToVerify) {
        String actualElement = elementToVerify.getText();
        Assert.assertEquals(expectedText, actualElement);
    }
    public static byte[] getByteScreenshot() throws IOException
    {
        File src = ((TakesScreenshot) TestHooks.driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(src);
        return fileContent;
    }
}
