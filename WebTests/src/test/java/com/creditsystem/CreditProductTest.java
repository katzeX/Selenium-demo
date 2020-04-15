package com.creditsystem;

import com.creditsystem.utils.CreditUtils;
import com.creditsystem.utils.UserUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreditProductTest {

    CreditProductPage creditProductPage;

    @Before
    public void setUp() {
        UserUtils.loginWithAdminRole();
        creditProductPage = Pages.creditProductPage();
        creditProductPage.goTo();
    }

    @After
    public void closeBrowser() { Browser.close(); }

    @Test
    public void shouldGetValidationAlertsCreateCreditProduct() {
        creditProductPage.completeFormInputs(CreditUtils.CREDIT_NAME, "0", "1", "100", "200");
        creditProductPage.submitValues();

        String expectedSumAlert = "The minimum sum is 3000";
        String expectedPeriodAlert = "The minimum period is 3";

        assertEquals(expectedSumAlert, creditProductPage.getText("sumMinMaxAlert"));
        assertEquals(expectedPeriodAlert, creditProductPage.getText("periodMinMaxAlert"));
    }

    @Test
    public void shouldCreateCreditAndGetMessage() {
        creditProductPage.completeFormInputs(CreditUtils.CREDIT_NAME, "3", "6", "30000", "200000");
        creditProductPage.annuityCheckBox.click();

        String expectedMessage = "The credit product " + CreditUtils.CREDIT_NAME + " was created.";
        creditProductPage.completeFormInputsAdditional("2", "1", "1");
        creditProductPage.submitValues();

        assertEquals(expectedMessage, creditProductPage.getText("modalContent"));
    }

}
