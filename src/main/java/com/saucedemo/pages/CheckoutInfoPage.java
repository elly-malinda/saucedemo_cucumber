package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInfoPage {

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//span[@class='title']")
    private WebElement lblChekoutInfoTitle;

    @FindBy(how = How.XPATH, using = "//input[@id='first-name']")
    private WebElement txtFirstName;

    @FindBy(how = How.XPATH, using = "//input[@id='last-name']")
    private WebElement txtLastName;

    @FindBy(how = How.XPATH, using = "//input[@id='postal-code']")
    private WebElement txtPostalCode;

    @FindBy(how = How.XPATH, using = "//button[@id='cancel']")
    private WebElement btnCancel;

    @FindBy(how = How.XPATH, using = "//input[@id='continue']")
    private WebElement btnContinue;

    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void EnterCheckoutInfo(String f_name, String l_name, String p_code)
    {
        //Populate Shipping details
        this.txtFirstName.sendKeys(f_name);
        this.txtLastName.sendKeys(l_name);
        this.txtPostalCode.sendKeys(p_code);
    }


    public void ClickContinue()
    {
        btnContinue.click();
    }

    public String getPageHeader()
    {
        return lblChekoutInfoTitle.getText();
    }

    public boolean CheckoutInfoDisplayed()
    {
        try
        {
            return (lblChekoutInfoTitle.isDisplayed());
        }
        catch(Exception e)
        {
            return false;
        }

    }


}
