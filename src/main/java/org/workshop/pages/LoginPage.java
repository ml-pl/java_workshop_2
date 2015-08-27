package org.workshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.workshop.framework.Page;

public class LoginPage extends Page{

    @FindBy(id = "user_login")
    private WebElement loginField;

    @FindBy(id = "user_pass")
    private WebElement passwordField;

    @FindBy(id = "wp-submit")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillLogin(String login){
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage fillPassword(String password){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        passwordField.sendKeys(password);
        return this;
    }

    public ProfilePage clickSubmit(){
        submitButton.click();
        return new ProfilePage(driver);
    }
}
