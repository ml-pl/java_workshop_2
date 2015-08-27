package org.workshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.workshop.model.Credentials;
import org.workshop.pages.MainPage;
import org.workshop.scenarios.LoginScenario;

public class LoginTest {

    @Test
    public void login() {
        WebDriver driver = new FirefoxDriver();

        new MainPage(driver)
                .clickLoginLink()
                .runScenario(new LoginScenario(new Credentials("workshop", "test")))
                .goToMainPage()
                .openPost("Witaj, świecie!");
//                .addComment("text");
    }
}
