package com.creditsystem.utils;

import com.creditsystem.Pages;

public class UserUtils {

    public static final String USERNAME_FOR_ADMIN_ROLE = "admin";

    public static final String PASSWORD_FOR_ADMIN_ROLE = "admin";

    public static void loginWithAdminRole() {
        Pages.loginPage().goTo();
        Pages.loginPage().insertValuesAndClick(UserUtils.USERNAME_FOR_ADMIN_ROLE, UserUtils.PASSWORD_FOR_ADMIN_ROLE);
    }
}
