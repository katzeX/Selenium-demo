package com.creditsystem;

import com.creditsystem.utils.PageName;
import com.creditsystem.utils.UserUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest {

    @After
    public void closeBrowser() {
        Browser.close();
    }

    @Test
    public void canGoToHomePage() {
        Pages.loginPage().goTo();
        assertTrue(Pages.loginPage().isAt());
    }

    @Test
    public void canLoginWithAdminCredentials() {
        Pages.loginPage().goTo();
        Pages.loginPage().insertValuesAndClick(UserUtils.USERNAME_FOR_ADMIN_ROLE, UserUtils.PASSWORD_FOR_ADMIN_ROLE);

        String actualPathURL = Browser.getCurrentURL();
        String actualUsername = Pages.welcomePage().getUsername();

        assertEquals(WelcomePage.WELCOME_PAGE,  actualPathURL);
        assertEquals(UserUtils.USERNAME_FOR_ADMIN_ROLE, actualUsername);
    }

}
