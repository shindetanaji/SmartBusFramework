package com.sm.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features = "src/test/java", glue = "com.sm.steps", 
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
@RunWith(Cucumber.class)
public class Runner {

}
