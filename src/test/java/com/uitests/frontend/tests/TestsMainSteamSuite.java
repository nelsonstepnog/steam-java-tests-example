package com.uitests.frontend.tests;

import com.uitests.frontend.helpers.DriverHelper;
import com.uitests.frontend.login.Login;
import com.uitests.frontend.pages.LoginPage;
import com.uitests.frontend.pages.MainPage;
import com.uitests.frontend.pages.MenuPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Class SteamTests
 * Класс UI-тестов для проверки тестовых сценариев на основной странице.
 */
public class TestsMainSteamSuite extends Login {
    private WebDriver driver = DriverHelper.getWebDriver();
    private Actions builder = new Actions(driver);

    /**
     * Метод для предварительных инициализаций перед тестом.
     */
    @Before
    public void steamMainBefore() {
        driver.get(LoginPage.goToPageURL);
        loginAsTestUser(driver);
    }

    /**
     * Метод для выполнения условий после прохождения теста.
     */
    @After
    public void steamMainAfter() {
        driver.navigate().refresh();
        driver.close();
    }

    /**
     * Позитивный тест с проверкой функционирования поля поиска.
     */
    @Test
    public void testSteamFindGame() {
        driver.findElement(MainPage.searchFieldPlaceholder);
        driver.findElement(MainPage.searchField).sendKeys("Squad");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(MainPage.searchResult).click();
        driver.findElement(MainPage.resultPage);
    }

    /**
     * Позитивный тест с проверкой функционирования меню под хэдером.
     */
    @Test
    public void testSteamMenuCheck() throws InterruptedException {
        builder.moveToElement(driver.findElement(MenuPage.yourShopMenuBtn)).build().perform();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(MenuPage.mainPageInMenu).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(MenuPage.mainPageText);
        builder.moveToElement(driver.findElement(MenuPage.gamesMenuBtn)).build().perform();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(MenuPage.freeInMenu).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(MenuPage.freePageText);
        builder.moveToElement(driver.findElement(MenuPage.sofwareMenuBtn)).build().perform();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(MenuPage.softwareInMenu).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(MenuPage.softwarePageText);
        builder.moveToElement(driver.findElement(MenuPage.hardwareMenuBtn)).build().perform();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(MenuPage.valveIndexInMenu).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(MenuPage.valveIndexPageText);
        driver.findElement(MenuPage.newsHardwareMenuBtn).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(MenuPage.newsHardwarePageText);
        driver.navigate().refresh();
        Thread.sleep(2000);
        builder.moveToElement(driver.findElement(MenuPage.yourShopMenuBtn)).build().perform();
        Thread.sleep(5000);
        driver.findElement(MenuPage.mainPageInMenu).click();
        driver.findElement(MenuPage.mainPageText);
    }
}
