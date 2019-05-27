package Steam.Page;

import org.openqa.selenium.By;

/**
 * Class LoginPage
 * Класс паттерна PageObject с описанием элементов страницы авторизации.
 */
public class LoginPage {

    /**
     * Кнопка перехода на страницу авторизации из домашней страницы.
     */
    public static By loginBtn = By.xpath("//*[@id='global_action_menu']/a");

    /**
     * Лэйбл поля имени на странице авторизации.
     */
    public static By nameLabel = By.xpath("//*[@id='login_form']/div[1]/div[text()='Имя аккаунта Steam']");

    /**
     * Поле имени на странице авторизации.
     */
    public static By nameField = By.id("input_username");

    /**
     * Лэйбл поля пароля на странице авторизации.
     */
    public static By passwordLabel = By.xpath("//*[@id='login_form']/div[2]/div[text()='Пароль']");

    /**
     * Поле пароля на странице авторизации.
     */
    public static By passwordField = By.id("input_password");

    /**
     * Кнопка входа на странице авторизации.
     */
    public static By submitBtn = By.xpath("//*[@id='login_btn_signin']/button");

    /**
     * Блок с элементами на странице авторизации.
     */
    public static By loginPageBlock = By.xpath("//*[@class='loginbox']");

    /**
     * Имя пользователя "testuserprojects" в раскрывающемся меню после успешной авторизации.
     */
    public static By userNameInMenu = By.xpath("//*[@id='account_pulldown'][text()='testuserprojects']");

    /**
     * Кнопка выхода из сервиса.
     */
    public static By logOutBtn = By.xpath("//*[@id='account_dropdown']/div/a[1][text()='Выйти']");

    /**
     * Сообщение об ошибке при заполнении невалидными данными полей при авторизации.
     */
    public static By wrongAuthMessage = By.xpath("//*[@id='error_display'][text()='Неверное имя аккаунта или пароль.']");
}