package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.*;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class complete_order {
    WebDriver driver;
    @Given("I launched saucedemo Application")
    public void iLaunchedSaucedemoApplication() {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //Open URL
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();

        }

        @When("I Authenticate with valid {string} and {string}")
        public void iAuthenticateWithValidAnd(String arg0, String arg1) throws InterruptedException
        {
        LoginPage lp = new LoginPage(driver);
        lp.enterLoginCredentials(arg0, arg1);
        lp.ClickLoginButton();
        ProductsPage pp = new ProductsPage(driver);
        boolean productsPage = pp.verifyProductPageDisplayed();
        Assert.assertEquals(productsPage, true, "Login Successful");
        Thread.sleep(3000);
        Assert.assertEquals(productsPage, true, "Products Page Displayed");
        Thread.sleep(3000);
        pp.SelectFirstItem();
        pp.SelectSecondItem();
        pp.ViewCart();

    }

        @And("I Enter shipping details {string}, {string} , {string} and Checkout Order")
        public void iEnterShippingDetailsAndCheckoutOrder(String arg0, String arg1, String arg2) throws InterruptedException {

        CartPage cp = new CartPage(driver);
        boolean cartPage = cp.CartPageDisplayed();
        Assert.assertEquals(cartPage, true, "Your Cart Displayed");
        Thread.sleep(2000);
        cp.ClickChekout();
        CheckoutInfoPage cip = new CheckoutInfoPage(driver);
        boolean checkoutPage = cip.CheckoutInfoDisplayed();
        Assert.assertEquals(checkoutPage, true, "Checkout Page displayed");
        cip.EnterCheckoutInfo(arg0, arg1, arg2);
        cip.ClickContinue();
        OverViewPage ovp = new OverViewPage(driver);
        boolean overViewPage = ovp.OverViewDisplayed();
        Assert.assertEquals(overViewPage, true, "Overview Page displayed");
        ovp.ClickFinish();

    }

        @Then("I verify that Order is Generated Successfully")
        public void iVerifyThatOrderIsGeneratedSuccessfully() {

        OrderConfirmationPage ocp = new OrderConfirmationPage(driver);
        boolean ordrConfPage = ocp.OrderConfirmation();
        Assert.assertEquals(ordrConfPage, true, "Overview Page displayed");
        String strConf = ocp.OrderConfirmationText();
        Assert.assertEquals(strConf,"Thank you for your order!");
        ocp.ClickBackHome();
        if (driver!=null)
        {
            driver.close();
        }


    }







}
