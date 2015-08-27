package org.workshop.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {

    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @SuppressWarnings("unchecked")
    public <In extends Page, Out extends Page> Out runScenario(Scenario<In, Out> scenario) {
        return scenario.run((In) this);
    }
}
