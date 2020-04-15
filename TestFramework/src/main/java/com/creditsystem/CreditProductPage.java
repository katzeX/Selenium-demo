package com.creditsystem;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.creditsystem.utils.*;

public class CreditProductPage extends PathPage {

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'CREATE PRODUCT')]")
     WebElement createProductLink;

    @FindBy(how = How.XPATH, using = "//h3[contains(.,'Create a new credit product')]")
     WebElement creditTitlePage;

    @FindBy(how = How.XPATH, using = "//input[@id='name']")
     WebElement creditNameInput;

    @FindBy(how = How.ID, using = "minTerm")
     WebElement minTermInput;

    @FindBy(how = How.ID, using = "maxTerm")
     WebElement maxTermInput;

    @FindBy(how = How.ID, using = "minSum")
     WebElement minSumInput;

    @FindBy(how = How.ID, using = "maxSum")
     WebElement maxSumInput;

    @FindBy(how = How.XPATH, using = "//button[@id='createProduct']")
     WebElement createProductButton;

    @FindBy(how = How.ID, using = "sumMinMaxAlert")
     WebElement minMaxSumAlert;

    @FindBy(how = How.ID, using = "periodMinMaxAlert")
     WebElement minMaxPeriodAlert;

    @FindBy(how = How.ID, using = "annuity")
     WebElement annuityCheckBox;

    @FindBy(how = How.ID, using = "interest")
     WebElement interestCheckBox;

    @FindBy(how = How.XPATH, using = "//form[@id='form']/div[4]/div/div/div/input")
     WebElement interestInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"interest\"]")
    WebElement commissionInput;

    @FindBy(how = How.XPATH, using = "//div[@id='values']/div[3]/input")
    WebElement fineInput;

    public void goTo() {
        Browser.goTo(PageName.CREDIT_PAGE);
    }

    public String pathName() {
        return null;
    }

    public void completeFormInputs(String name, String minTerm, String maxTerm, String minSum, String maxSum) {
       creditNameInput.sendKeys(name);
       minTermInput.sendKeys(minTerm);
       maxTermInput.sendKeys(maxTerm);
       minSumInput.sendKeys(minSum);
       maxSumInput.sendKeys(maxSum);
    }


    public void completeFormInputsAdditional(String interest, String commission, String fine) {
        interestInput.sendKeys(interest);
        commissionInput.sendKeys(commission);
        fineInput.sendKeys(fine);
    }

    public void submitValues() {
        createProductButton.click();
    }

    public String getText(String id) {
        WebElement webElement = Browser.findElement(id);
        if (webElement != null) {
            return webElement.getText(); }
        else return "";
    }

    public boolean getIfIsChecked(String id) {
        if (id.equalsIgnoreCase("Annuity Capital and Interest")) {
             return annuityCheckBox.isSelected(); }
        else return false;

    }

    public void waitFor() {
        Browser.waitForElement(creditTitlePage, "//h3[contains(.,'Create a new credit product')]");
    }


}
