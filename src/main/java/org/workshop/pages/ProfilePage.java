package org.workshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.workshop.framework.Page;

import static org.hamcrest.MatcherAssert.assertThat;

public class ProfilePage extends Page {

    @FindBy(partialLinkText = "Java Workshop")
    private WebElement mainPageLink;

    @FindBy(id = "wp-admin-bar-my-account")
    private WebElement logoutLink;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public MainPage goToMainPage() {
        mainPageLink.click();
        return new MainPage(driver);
    }

    public ProfilePage assertLoggedIn() {
        assertThat("user is logged", logoutLink.isDisplayed());
        return this;
    }
}
