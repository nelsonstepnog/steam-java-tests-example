package Steam.Tests;

import Steam.Page.LoginPage;
import Steam.Page.MainPage;
import Steam.Page.MenuPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Class SteamTests
 * Класс UI-тестов для проверки тестовых сценариев на основной странице.
 */
public class TestsMainSteam {
    private WebDriver driver;
    private Actions builder;
    private String login;
    private String password;

    /**
     * Метод для предварительных инициализаций перед тестом.
     */
    @Before
    public void steamMainBefore() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/share/chromedriver");
        login    = "testuserprojects";
        password = "testuserUniform64";
        driver   = new ChromeDriver();
        builder  = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://store.steampowered.com/");
    }

    /**
     * Метод для выполнения условий после прохождения теста.
     */
    @After
    public void steamMainAfter() {
        driver.close();
    }

    /**
     * Позитивный тест с проверкой функционирования поля поиска.
     */
    @Test
    public void testSteamFindGame() {
        driver.findElement(LoginPage.loginBtn).click();
        driver.findElement(LoginPage.nameLabel);
        driver.findElement(LoginPage.nameField).sendKeys(login);
        driver.findElement(LoginPage.passwordLabel);
        driver.findElement(LoginPage.passwordField).sendKeys(password);
        driver.findElement(LoginPage.submitBtn).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(LoginPage.userNameInMenu);
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
        driver.findElement(LoginPage.loginBtn).click();
        driver.findElement(LoginPage.nameLabel);
        driver.findElement(LoginPage.nameField).sendKeys(login);
        driver.findElement(LoginPage.passwordLabel);
        driver.findElement(LoginPage.passwordField).sendKeys(password);
        driver.findElement(LoginPage.submitBtn).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(LoginPage.userNameInMenu);
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
