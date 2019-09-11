package model.ui.base;

import org.junit.Before;

import com.codeborne.selenide.Configuration;

import toolkit.DataProvider;


/**
 * Provides basic configuration for test environment of every test of user
 * interface.
 * 
 * @author Nikolai Grunin
 */
public abstract class Base
{

    /**
     * Sets system property for selenium browser driver and basic selenide library configuration.
     */
    @Before
    public void setUp()
    {
        /**Setup for local running of test*/
        DataProvider.getDataProvider();
        System.setProperty(CHROME_KEY, CHROME_PATH);
        Configuration.browser = CHROME_CONF;
        Configuration.startMaximized = true;
        Configuration.timeout = 30000;
    }
    static private final String CHROME_PATH = "src\\test\\resources\\chromedriver.exe";
    static private final String CHROME_KEY = "webdriver.chrome.driver";
    static private final String CHROME_CONF =  "chrome";
}