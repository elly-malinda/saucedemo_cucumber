package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class saucedemo_login {
    WebDriver driver;
    @Given("I launched saucedemo application home page")
    public void i_launched_saucedemo_application_home_page() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Open URL
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

    }

    @When("I Login with valid user {string} and pwd {string}")
    public void iLoginWithValidUserAndPwd(String arg0, String arg1) {
        LoginPage lp = new LoginPage(driver);
        lp.enterLoginCredentials(arg0, arg1);
        lp.ClickLoginButton();
    }

    @Then("I verify that user is successfully authenticated")
    public void i_verify_that_user_is_successfully_authenticated() {

        ProductsPage pp = new ProductsPage(driver);
        boolean productsPage = pp.verifyProductPageDisplayed();
        Assert.assertEquals(productsPage, true, "Login Successful");
        //Quit Browser

        driver.close();

    }



}
