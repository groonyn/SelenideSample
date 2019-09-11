package model.ui.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Provides description of AAX Main page to test with 'field page object' approach.
 *
 * @author Nikolai Grunin
 */
public class MainPage
{
    /**
     * Finishes authorization of user by logging out of portal.
     * @return the instance of current page object.
     */
    public MainPage logout()
    {
        logoutButton.shouldBe(visible).click();
        return this;
    }

    /* Fields of page elements*/
    private SelenideElement logoutButton = $(By.xpath(LOGOUT_BUTTON));
    /* Fields describing locators*/
    static private final String LOGOUT_BUTTON = "//*[contains(@id,'formLogout:buttonLogout')]";
}
