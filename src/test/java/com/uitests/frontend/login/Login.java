package com.uitests.frontend.login;

import com.uitests.frontend.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Class Login
 * Класс для авторизации пользователей на странице сервиса.
 */
public class Login {
    public static String login = "testuserprojects";
    public static String password = "testuserUniform64";
    private static WebDriver driver;

    protected static WebDriver getWebDriver() {
        driver = new ChromeDriver();
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    /**
     * Метод класса Login с предварительными инициализациями, выполняющийся перед тестом.
     */
    protected void loginAsTestUser() {
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver");
        driver.manage().window().maximize();
        driver.get(LoginPage.goToPageURL);
        driver.findElement(LoginPage.loginBtn).click();
        driver.findElement(LoginPage.nameLabel);
        driver.findElement(LoginPage.nameField).sendKeys(login);
        driver.findElement(LoginPage.passwordLabel);
        driver.findElement(LoginPage.passwordField).sendKeys(password);
        driver.findElement(LoginPage.submitBtn).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(LoginPage.userNameInMenu);
    }
}
