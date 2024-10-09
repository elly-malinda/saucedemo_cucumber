package com.saucedemo.pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage /*extends BasePage*/ {

    private WebDriver driver;

    @FindBy(how = How.ID, using = "user-name")
    private WebElement txtUserName;

    @FindBy(how = How.ID, using = "password")
    private WebElement txtPassword;

    @FindBy(how = How.ID, using = "login-button")
    private WebElement btnLogin;

    @FindBy(how = How.XPATH, using = "//div[@class='login_logo']")
    private WebElement pageHeader;

    @FindBy(how = How.XPATH, using = "//h3[contains(text(),'Epic sadface: Sorry, this user has been locked out')]")
    private WebElement loginError;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickLoginButton() {
        this.btnLogin.click();
    }

    public void enterLoginCredentials(String str_user, String str_pwd) {
        //Enter User Login Credentials
        this.txtUserName.clear();
        this.txtUserName.sendKeys(str_user);
        this.txtPassword.clear();
        this.txtPassword.sendKeys(str_pwd);

    }

    public String getPageHeader() {
        return pageHeader.getText();
    }

    public boolean LoginErrorDisplayed()
    {
        try
        {
            return (loginError.isDisplayed());
        }
        catch(Exception e)
        {
            return false;
        }

    }


}
