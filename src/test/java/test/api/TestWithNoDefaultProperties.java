package test.api;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import toolkit.DataProvider;

import static toolkit.DataProvider.*;

/**
 * Test with no default property. Paths to properties must be defined
 *  via -D parameter as a part of Maven goal: -Dsecond.file=/second.cfg -Ddefault.file=nofile
 * 
 * @author Nikolai Grunin
 */
public class TestWithNoDefaultProperties
{
    /**
     * Checks getting values of property by key with no default file with
     * property case.
     */
    @Ignore
    @Test(expected = RuntimeException.class)
    public void testGetPropertyContainingNoDefaultProperty()
    {
        DataProvider.getNewSingleDataProvider();
        String actualSecondProperty = getNewSingletonProviderProperty(ENVIRONMENT_ID);
        Assert.assertEquals(VALID_VALUE, actualSecondProperty);
    }

    /* Test message and data templates. */
    static private final String VALID_VALUE = "SECOND";
    static private final String ENVIRONMENT_ID = "environment.id";
}
