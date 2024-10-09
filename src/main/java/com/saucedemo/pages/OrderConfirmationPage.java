package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//span[@class='title']")
    private WebElement ttlChekpoutComplete;

    @FindBy(how = How.XPATH, using = "//h2[normalize-space()='Thank you for your order!']")
    private WebElement lblOrderConfText;

    @FindBy(how = How.XPATH, using = "//button[@id='back-to-products']")
    private WebElement btnBackHome;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickBackHome()
    {
        this.btnBackHome.click();
    }

    public String OrderConfirmationText()
    {
        //Verify Order message
        try {
            return lblOrderConfText.getText();
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }

    public boolean OrderConfirmation()
    {
        //Verify Order message
        try {
            return lblOrderConfText.isDisplayed();
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
