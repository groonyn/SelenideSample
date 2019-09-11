package test.api;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import toolkit.DataProvider;

import static toolkit.DataProvider.*;

/**
 * Test with no second property. Paths to properties must be defined 
 * via -D parameter as a part of Maven goal: -Dsecond.file=nofile -Ddefault.file=/default.cfg 
 * @author Nikolai Grunin
 */
public class TestWithNoSecondProperties
{
    /**
     * Checks getting values of property by key with no second file with
     * property case.
     */
    @Ignore
    @Test(expected = RuntimeException.class)
    public void testGetPropertyContainingNoSecondProperty()
    {
        DataProvider.getNewSingleDataProvider();
        String actualDefaultProperty = getNewSingletonProviderProperty(KEY_IS_ONLY_IN_DEFAULT_FILE);
        Assert.assertEquals(ONLY_IN_DEFAULT_VALUE, actualDefaultProperty);
    }

    /* Test message and data templates. */
    static private final String KEY_IS_ONLY_IN_DEFAULT_FILE = "only.default.key";
    static private final String ONLY_IN_DEFAULT_VALUE = "default_value";
}
