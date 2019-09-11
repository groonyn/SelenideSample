package test.ui;

import model.ui.base.Base;
import model.ui.pages.AuthorizatonPage;
import model.ui.pages.MainPage;
import org.junit.AfterClass;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.close;
import static toolkit.DataProvider.*;

/**
* Test of full authorization process.
*
* @author Nikolai Grunin
*/
public class TestAuthorization extends Base
{
    /**
     * Closes Selenium Web Driver instance after test class.
     */
    @AfterClass
    public static void tearDown()
    {
        close();
    }

    /**
     * Test authorizes to authorization page and logouts from main page.
     * Uses URL of authorization page and credentials via DataProvider class properties implementation.
     */
    @Test
    public void testLoginLogout()
    {
        authorizatonPage.open(URL);
        authorizatonPage.login(LOGIN, PASSWORD);
        mainPage.logout();
    }

    /*Login data fields*/
    final private String URL = getProviderProperty("portal.url");
    final private String LOGIN = getProviderProperty("login");
    final private String PASSWORD = getProviderProperty("password");

    /*Objects of testing pages*/
    final private AuthorizatonPage authorizatonPage = new AuthorizatonPage();
    final private MainPage mainPage = new MainPage();
}
