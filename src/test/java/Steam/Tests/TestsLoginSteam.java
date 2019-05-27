package Steam.Tests;

import Steam.Page.LoginPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Class TestsLoginSteam
 * Класс UI-тестов для проверки страницы авторизации.
 */
public class TestsLoginSteam {
    private WebDriver driver;
    private String login;
    private String password;

    /**
     * Метод для предварительных инициализаций перед тестом.
     */
    @Before
    public void steamLoginBefore() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/share/chromedriver");
        login    = "testuserprojects";
        password = "testuserUniform64";
        driver   = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://store.steampowered.com/");
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
        driver.findElement(LoginPage.nameField).sendKeys(login);
        driver.findElement(LoginPage.passwordLabel);
        driver.findElement(LoginPage.passwordField).sendKeys(password);
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
        driver.findElement(LoginPage.nameField).sendKeys(login);
        driver.findElement(LoginPage.passwordLabel);
        driver.findElement(LoginPage.passwordField).sendKeys(password);
        driver.findElement(LoginPage.submitBtn).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(LoginPage.userNameInMenu);
    }

    /**
     * Негативный тест с проверкой страницы авторизации под обычным пользователем с невалидными логином.
     */
    @Test
    public void testSteamAuthWithWrongName() {
        driver.findElement(LoginPage.loginBtn).click();
        driver.findElement(LoginPage.nameField).sendKeys("wrongName");
        driver.findElement(LoginPage.passwordField).sendKeys(password);
        driver.findElement(LoginPage.submitBtn).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(LoginPage.wrongAuthMessage);
        driver.findElement(LoginPage.nameField).clear();
        driver.findElement(LoginPage.passwordField).clear();
        driver.findElement(LoginPage.nameLabel);
        driver.findElement(LoginPage.nameField).sendKeys(login);
        driver.findElement(LoginPage.passwordLabel);
        driver.findElement(LoginPage.passwordField).sendKeys(password);
        driver.findElement(LoginPage.submitBtn).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(LoginPage.userNameInMenu);
    }

    /**
     * Негативный тест с проверкой страницы авторизации под обычным пользователем с невалидными паролем.
     */
    @Test
    public void testSteamAuthWithWrongPassword() {
        driver.findElement(LoginPage.loginBtn).click();
        driver.findElement(LoginPage.nameField).sendKeys(login);
        driver.findElement(LoginPage.passwordField).sendKeys("wrongPassword");
        driver.findElement(LoginPage.submitBtn).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(LoginPage.wrongAuthMessage);
        driver.findElement(LoginPage.nameField).clear();
        driver.findElement(LoginPage.passwordField).clear();
        driver.findElement(LoginPage.nameLabel);
        driver.findElement(LoginPage.nameField).sendKeys(login);
        driver.findElement(LoginPage.passwordLabel);
        driver.findElement(LoginPage.passwordField).sendKeys(password);
        driver.findElement(LoginPage.submitBtn).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(LoginPage.userNameInMenu);
    }

    /**
     * Негативный тест с проверкой страницы авторизации под обычным пользователем без заполнения поля логина.
     */
    @Test
    public void testSteamAuthWithoutName() {
        driver.findElement(LoginPage.loginBtn).click();
        driver.findElement(LoginPage.nameField).sendKeys("");
        driver.findElement(LoginPage.passwordField).sendKeys(password);
        driver.findElement(LoginPage.submitBtn).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(LoginPage.loginPageBlock);
        driver.findElement(LoginPage.nameField).clear();
        driver.findElement(LoginPage.passwordField).clear();
        driver.findElement(LoginPage.nameLabel);
        driver.findElement(LoginPage.nameField).sendKeys(login);
        driver.findElement(LoginPage.passwordLabel);
        driver.findElement(LoginPage.passwordField).sendKeys(password);
        driver.findElement(LoginPage.submitBtn).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(LoginPage.userNameInMenu);
    }

    /**
     * Негативный тест с проверкой страницы авторизации под обычным пользователем без заполнения поля пароля.
     */
    @Test
    public void testSteamAuthWithoutPassword() {
        driver.findElement(LoginPage.loginBtn).click();
        driver.findElement(LoginPage.nameField).sendKeys(login);
        driver.findElement(LoginPage.passwordField).sendKeys("");
        driver.findElement(LoginPage.submitBtn).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(LoginPage.loginPageBlock);
        driver.findElement(LoginPage.nameField).clear();
        driver.findElement(LoginPage.passwordField).clear();
        driver.findElement(LoginPage.nameLabel);
        driver.findElement(LoginPage.nameField).sendKeys(login);
        driver.findElement(LoginPage.passwordLabel);
        driver.findElement(LoginPage.passwordField).sendKeys(password);
        driver.findElement(LoginPage.submitBtn).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(LoginPage.userNameInMenu);
    }
}
