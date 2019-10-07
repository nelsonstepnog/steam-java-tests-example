package com.uitests.frontend.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverHelper {

    public static WebDriver driver;

    public static WebDriver getWebDriver() {
        System.setProperty("wdm.targetPath", "../steam-java-tests-example/resources");
        WebDriverManager.chromedriver().clearPreferences();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }
}
