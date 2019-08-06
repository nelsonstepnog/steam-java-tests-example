package com.steam.frontend.pages;

import org.openqa.selenium.By;

/**
 * Class MenuPage
 * Класс паттерна PageObject с описанием элементов в меню на главной странице сайта.
 */
public class MenuPage {

    /**
     * Кнопка меню "Ваш магазин" на главной странице.
     */
    public static By yourShopMenuBtn = By.xpath("//*[@id='foryou_tab']/span/a[text()='Ваш магазин']");

    /**
     * Кнопка подменю "Главная страница" в выпадающем списке меню "Ваш магазин".
     */
    public static By mainPageInMenu = By.xpath("//*[@class='popup_body popup_menu']/a[contains(text(), 'Главная страница')]");

    /**
     * Текст на странице "Главная страница".
     */
    public static By mainPageText = By.xpath("//*[text()='Популярное и рекомендуемое']");

    /**
     * Кнопка меню "Игры" на главной странице.
     */
    public static By gamesMenuBtn = By.xpath("//*[@id='genre_tab']/span/a[text()='Игры']/parent::span");

    /**
     * Кнопка подменю "Бесплатно" в выпадающем списке меню "Игры".
     */
    public static By freeInMenu = By.xpath("//*[@class='popup_body popup_menu']/a[contains(text(), 'Бесплатно')]");

    /**
     * Текст на странице "Бесплатно".
     */
    public static By freePageText = By.xpath("//*[text()='Бесплатные игры в Steam']");

    /**
     * Кнопка меню "Программы" на главной странице.
     */
    public static By sofwareMenuBtn = By.xpath("//*[@id='software_tab']/span/a[text()='Программы']/parent::span");

    /**
     * Кнопка подменю "Программы" в выпадающем списке меню "Программы".
     */
    public static By softwareInMenu = By.xpath("//*[@class='popup_body popup_menu']/a[contains(text(), 'Программы')]");

    /**
     * Текст на странице "Программы".
     */
    public static By softwarePageText = By.xpath("//*[text()='Программы в Steam']");

    /**
     * Кнопка меню "Устройства" на главной странице.
     */
    public static By hardwareMenuBtn = By.xpath("//*[@id='hardware_tab']/span/a[text()='Устройства']/parent::span");

    /**
     * Кнопка подменю "Valve Index" в выпадающем списке меню "Устройств".
     */
    public static By valveIndexInMenu = By.xpath("//*[@class='popup_body popup_menu']/a[contains(text(), 'Valve Index')]");

    /**
     * Текст на странице "Valve Index".
     */
    public static By valveIndexPageText = By.xpath("//*[text()='Valve Index VR Kit']");

    /**
     * Кнопка меню "Новости" на главной странице.
     */
    public static By newsHardwareMenuBtn = By.xpath("//*[@id='store_nav_area']/div[2]/div/a/span[text()='Новости']");

    /**
     * Текст на странице "Новости".
     */
    public static By newsHardwarePageText = By.xpath("//*[text()='Все новости']");
}
