package com.uitests.frontend.helpers;

import com.uitests.frontend.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverHelper {

    public static WebDriver driver;
    public static int timeOut = 15;

    public static WebDriver getWebDriver() {
        System.setProperty("wdm.targetPath", "../steam-java-tests-example/src/test/java/com/resources");
        WebDriverManager.chromedriver().clearPreferences();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        if (driver == null) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(LoginPage.goToPageURL);
        return driver;
    }
}
