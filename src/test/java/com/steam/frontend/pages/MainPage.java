package com.steam.frontend.pages;

import org.openqa.selenium.By;

/**
 * Class MainPage
 * Класс паттерна PageObject с описанием элементов главной страницы сайта.
 */
public class MainPage {

    /**
     * Поле поиска на главной странице.
     */
    public static By searchField = By.id("store_nav_search_term");

    /**
     * Плейсхолдер в поле поиска на главной странице.
     */
    public static By searchFieldPlaceholder = By.xpath("//*[@class='searchbox']/input[@placeholder='поиск по магазину']");

    /**
     * Поиск конкретного результата в выпадающем списке поля поиска на главной странице.
     */
    public static By searchResult = By.xpath("//*[@class='match_name'][text()='Squad']/parent::a");

    /**
     * Название "Squad" на странице найденной игры.
     */
    public static By resultPage = By.xpath("//*[@class='apphub_AppName'][text()='Squad']");
}
