package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//span[@class='title']")
    private WebElement productPageTitle;

    @FindBy(how = How.XPATH, using = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement firstItem;

    @FindBy(how = How.XPATH, using = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement secondtItem;

    @FindBy(how = How.XPATH, using = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    private WebElement thirdtItem;

    @FindBy(how = How.XPATH, using = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
    private WebElement fourthtItem;

    @FindBy(how = How.XPATH, using = "//a[@class='shopping_cart_link']")
    private WebElement viewCart;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ViewCart()
    {
        this.viewCart.click();
    }

    public void SelectFirstItem()
    {
        this.firstItem.click();
    }

    public void SelectSecondItem()
    {
        this.secondtItem.click();
    }

    public boolean verifyProductPageDisplayed() {

        try
        {
            return (productPageTitle.isDisplayed());
        }
        catch(Exception e)
        {
            return false;
        }
    }


}
