package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OverViewPage {

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//span[@class='title']")
    private WebElement OverviewTitle;

    @FindBy(how = How.XPATH, using = "//div[normalize-space()='Free Pony Express Delivery!']")
    private WebElement lblDeliveryDetails;

    @FindBy(how = How.XPATH, using = "//div[@class='summary_total_label']")
    private WebElement lblTotalSummary;

    @FindBy(how = How.XPATH, using = "//button[@id='cancel']")
    private WebElement btnCancel;

    @FindBy(how = How.XPATH, using = "//button[@id='finish']")
    private WebElement btnFinish;

    public void ClickFinish()
    {
        this.btnFinish.click();
    }

    public boolean OverViewDisplayed()
    {
        try
        {
            return (OverviewTitle.isDisplayed());
        }
        catch(Exception e)
        {
            return false;
        }

    }


    public OverViewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
