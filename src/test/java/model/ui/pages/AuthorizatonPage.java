package model.ui.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Provides description of AAX Authorizaton page to test with 'field page object' approach.
 * 
 * @author Nikolai Grunin
 */
public class AuthorizatonPage
{
    /** 
     * Opens page by link.
     * @param url of page to open.
     * @return the instance of current page object.
     */
    public AuthorizatonPage open(String url)
    {
        Selenide.open(url);
        return this;
    }

    /**
     * Authorizes to portal using credentials.
     * @param login - String of login data.
     * @param password - String of password data.
     * @return the instance of current page object.
     */
    public AuthorizatonPage login(String login, String password)
    {
        loginInput.shouldBe(visible).setValue(login);
        passwordInput.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
        return this;
    }

    /* Fields of page elements*/
    private SelenideElement loginInput = $(By.xpath(LOGIN_INPUT));
    private SelenideElement passwordInput = $(By.xpath(PASSWORD_INPUT));
    private SelenideElement loginButton = $(By.xpath(LOGIN_BUTTON));
    /* Fields describing locators*/
    static private final String LOGIN_INPUT = "//*[contains(@id,'loginForm:username')]";
    static private final String PASSWORD_INPUT = "//*[contains(@id,'loginForm:password')]";
    static private final String LOGIN_BUTTON = "//*[contains(@id,'loginForm:Login')]";
}
