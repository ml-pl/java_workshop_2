package org.workshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.workshop.framework.Page;

import java.util.List;

public class MainPage extends Page {

    private static String url = "http://wordpress-keepsake.rhcloud.com/";

    @FindBy(linkText = "Zaloguj się")
    private WebElement loginLink;

    @FindBy(css = "h2.entry-title a")
    private List<WebElement> posts;

    public MainPage(WebDriver driver) {
        super(driver);
        driver.get(url);
    }

    public LoginPage clickLoginLink() {
        loginLink.click();
        return new LoginPage(driver);
    }

    public MainPage openPost(String postTitle) {
        for (WebElement post : posts) {
            if (post.getText().equals(postTitle)) {
                post.click();
            }
        }
        return this;
    }

}
