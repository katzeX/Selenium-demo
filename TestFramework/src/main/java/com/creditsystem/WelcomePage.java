package com.creditsystem;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WelcomePage extends PathPage {

    static final String WELCOME_PAGE = "http://localhost:8080/creditsystem/hello";

    @FindBy(how = How.CSS, using = ".nav-link > span")
    WebElement username;

    public void goTo() {
        Browser.goTo(WELCOME_PAGE);
    }

    public String pathName() {
        return WELCOME_PAGE;
    }

    public String getUsername() {
        return username.getText();
    }

}
