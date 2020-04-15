package com.creditsystem;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends PathPage {

    static final String LOGIN_PAGE = "localhost:8080/creditsystem/";
    static String title = "Online Credit System";

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/form/input[1]")
     WebElement usernameInput;

    @FindBy(how = How.XPATH, using = "//input[@name='password']")
     WebElement passwordInput;

    @FindBy(how = How.NAME, using = "login")
     WebElement loginButton;

    public void goTo() {
        Browser.goTo(LOGIN_PAGE);
    }

    public String pathName() {
        return LOGIN_PAGE;
    }

    public boolean isAt() {
        return Browser.title().equals(title);
    }

    public void insertValuesAndClick(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        loginButton.submit();
    }


}
