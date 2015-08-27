package org.workshop.scenarios;

import org.workshop.framework.Scenario;
import org.workshop.model.Credentials;
import org.workshop.pages.LoginPage;
import org.workshop.pages.ProfilePage;

public class LoginScenario implements Scenario<LoginPage, ProfilePage> {

    private Credentials credentials;

    public LoginScenario(Credentials credentials) {
        this.credentials = credentials;
    }

    public ProfilePage run(LoginPage loginPage) {
        return loginPage.fillLogin(credentials.getLogin())
                .fillPassword(credentials.getPassword())
                .clickSubmit()
                .assertLoggedIn();
    }
}
