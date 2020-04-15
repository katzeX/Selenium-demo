package com.creditsystem;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Browser {

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Programs\\chrome driver\\chromedriver.exe");
    }

    static WebDriver driver = new ChromeDriver();


    public static void goTo(String url) {
        driver.get(url);
    }

    public static String title() {
        return driver.getTitle();
    }

    public static String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public static void close() {
        driver.close();
        driver.quit();
    }

    public static void waitFor(long sec) {
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

    public static void waitForElement(WebElement webElement, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 20L);
        webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static WebElement findElement(String id) {
        try {
            return driver.findElement(By.id(id));
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public static boolean getChecked(String css) {
        return driver.findElement(By.cssSelector(css)).isSelected();
    }
}
