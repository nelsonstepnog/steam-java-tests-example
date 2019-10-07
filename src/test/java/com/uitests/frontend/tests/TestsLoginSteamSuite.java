package com.uitests.frontend.tests;

import com.uitests.frontend.pages.LoginPage;
import com.uitests.frontend.login.Login;
import com.uitests.frontend.helpers.DriverHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Class TestsLoginSteamSuite
 * Класс UI-тестов для проверки страницы авторизации.
 */
public class TestsLoginSteamSuite {
    private WebDriver driver = DriverHelper.getWebDriver();

    /**
     * Метод для предварительных инициализаций перед тестом.
     */
    @Before
    public void steamLoginBefore() {
        driver.manage().window().maximize();
        driver.get(LoginPage.goToPageURL);
    }

    /**
     * Метод для выполнения условий после прохождения теста.
     */
    @After
    public void steamLoginAfter() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    /**
     * Позитивный тест с проверкой страницы авторизации под обычным пользователем.
     */
    @Test
    public void testSteamAuth() throws InterruptedException {
        driver.findElement(LoginPage.loginBtn).click();
        driver.findElement(LoginPage.nameLabel);
        driver.findElement(LoginPage.nameField).sendKeys(Login.login);
        driver.findElement(LoginPage.passwordLabel);
        driver.findElement(LoginPage.passwordField).sendKeys(Login.password);
        driver.findElement(LoginPage.submitBtn).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(LoginPage.userNameInMenu).click();
        driver.findElement(LoginPage.logOutBtn).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElements((LoginPage.userNameInMenu)).isEmpty());
    }

    /**
     * Негативный тест с проверкой страницы авторизации под обычным пользователем с невалидными логином и паролем.
     */
    @Test
    public void testSteamAuthWrongNameAndPassword() {
        driver.findElement(LoginPage.loginBtn).click();
        driver.findElement(LoginPage.nameField).sendKeys("wrongName");
        driver.findElement(LoginPage.passwordField).sendKeys("wrongPassword");
        driver.findElement(LoginPage.submitBtn).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(LoginPage.wrongAuthMessage);
        driver.findElement(LoginPage.nameField).clear();
        driver.findElement(LoginPage.passwordField).clear();
        driver.findElement(LoginPage.nameLabel);
        driver.findElement(LoginPage.nameField).sendKeys(Login.login);
        driver.findElement(LoginPage.passwordLabel);
        driver.findElement(LoginPage.passwordField).sendKeys(Login.password);
        driver.findElement(LoginPage.submitBtn).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(LoginPage.userNameInMenu);
    }
}
