package com.pisano.automation.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "com.pisano.automation.steps",
        "com.pisano.automation.hooks" },
plugin = { "pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class CucumberTestRunner {



}
