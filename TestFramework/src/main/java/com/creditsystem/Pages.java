package com.creditsystem;

import org.openqa.selenium.support.PageFactory;

public class Pages {

    public static LoginPage loginPage() {
        LoginPage loginPage = new LoginPage();
        PageFactory.initElements(Browser.driver, loginPage);
        return loginPage;
    }

    public static WelcomePage welcomePage() {
        WelcomePage welcomePage = new WelcomePage();
        PageFactory.initElements(Browser.driver, welcomePage);
        return welcomePage;
    }

    public static CreditProductPage creditProductPage() {
        CreditProductPage creditProductPage = new CreditProductPage();
        PageFactory.initElements(Browser.driver, creditProductPage);
        return creditProductPage;
    }


}
