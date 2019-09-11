package test.api;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import toolkit.DataProvider;

import static toolkit.DataProvider.getNewSingletonProviderProperty;

/**
 * Test without any property. Paths to properties must be defined via
 * -D parameter as a part of Maven goal: -Dsecond.file=nofile -Ddefault.file=nofile 
 * @author Nikolai Grunin
 */
public class TestWithoutPropertiesFiles
{
    /**
     * Checks getting values of property by key without any property file with
     * property case.
     */
    @Ignore
    @Test(expected = RuntimeException.class)
    public void testGetPropertyWithoutSecondOrDefaultProp()
    {
        DataProvider.getNewSingleDataProvider();
        String actualSecondProperty = getNewSingletonProviderProperty(ENVIRONMENT_ID);
        String actualDefaultProperty = getNewSingletonProviderProperty(KEY_IS_ONLY_IN_DEFAULT_FILE);

        Assert.assertNull(actualSecondProperty);
        Assert.assertNull(actualDefaultProperty);
    }

    /* Test message and data templates. */
    static private final String KEY_IS_ONLY_IN_DEFAULT_FILE = "only.default.key";
    static private final String ENVIRONMENT_ID = "environment.id";
}
