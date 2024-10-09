package com.saucedemo.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/saucedemo/features",
        glue = {"com.saucedemo", "com.saucedemo.stepdefinitions"},
        plugin = {"pretty", "html:target/html/cucumber.html", "json:target/Json/cucumber.json", "junit:target/Junit/Junit.xml"},
        monochrome = true
)
public class RunCucumberTest {
}
