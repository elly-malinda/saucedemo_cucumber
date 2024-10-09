package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.LoginPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class invalid_user_details {
    WebDriver driver;

    @Given("I navigate to saucedemo application home page")
    public void i_navigate_to_saucedemo_application_home_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Open URL
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @When("I enter invalid user {string} and pwd {string} details")
    public void i_enter_invalid_user_and_pwd_details(String string, String string2) {
        LoginPage lp = new LoginPage(driver);
        lp.enterLoginCredentials(string, string2);
        lp.ClickLoginButton();
    }

    @Then("User Authentication Fails")
    public void user_authentication_fails() {
        LoginPage lp = new LoginPage(driver);
        boolean loginErr = lp.LoginErrorDisplayed();
        //Verify Landing Page
        Assert.assertEquals(loginErr, true, "Login Failed");
        //Quit Browser
        if(driver !=null)
        {
            driver.close();
        }
    }

}
