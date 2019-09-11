package test.api;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import toolkit.DataProvider;

import static toolkit.DataProvider.getNewSingletonProviderProperty;

/**
 * Test with valid second and valid default property. 
 * Paths to properties must be defined via 
 * -D parameter as a part of Maven goal: -Dsecond.file=/second.cfg -Ddefault.file=/default.cfg 
 * @author Nikolai Grunin
 */
public class TestWithValidSystemProperties
{
    /**
     * Checks getting values of property by keys with two cases. It must take
     * the unique value by unique key which is only exists in one of two
     * properties.
     */
    @Ignore
    @Test
    public void testGetPropertyWithBothExistingSystemProperties()
    {
        DataProvider.getNewSingleDataProvider();

        String currentSecondProperty = getNewSingletonProviderProperty(ENVIRONMENT_ID);
        Assert.assertEquals(VALID_VALUE, currentSecondProperty);

        String currentDefaultProperty = getNewSingletonProviderProperty(KEY_IS_ONLY_IN_DEFAULT_FILE);
        Assert.assertEquals(ONLY_IN_DEFAULT_VALUE, currentDefaultProperty);
    }

    /* Test message and data templates. */
    static private final String KEY_IS_ONLY_IN_DEFAULT_FILE = "only.default.key";
    static private final String ONLY_IN_DEFAULT_VALUE = "default_value";
    static private final String VALID_VALUE = "SECOND";
    static private final String ENVIRONMENT_ID = "environment.id";
}
