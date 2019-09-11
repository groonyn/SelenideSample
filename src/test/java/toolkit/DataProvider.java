package toolkit;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class provides interface to work with project properties It reads data
 * from files in a key=value style and make cache for each file. By
 * implementation instance of class is singleton containing properties located
 * by path of resource. It allows to use java system properties via command line
 * with -D argument for two property files defining path with syntax as follows:
 * -Ddefault.file=/default.cfg and -Dsecond.file=/second.cfg
 * 
 * @author Nikolai Grunin
 */
public class DataProvider
{
    /**
     * Creates instance consisting of provided data from two files read and
     * stored in properties.
     *
     */
    private DataProvider()
    {
        String pathToDefault = System.getProperty(DEFAULT_FILE);
        Properties defaultProperties = new Properties();

        this.propertiesInstance = defaultProperties;
        loadDataTo(pathToDefault, defaultProperties);

        String pathToSecond = System.getProperty(SECOND_FILE);
        loadDataTo(pathToSecond, defaultProperties);
    }

    /**
     * Fills property instance by data from file
     * 
     * @param pathName
     *            - name of desired resource to read
     * @param propertyToFill
     *            - property instance to be filled by data
     * @throws IllegalArgumentException
     *             Properties file have invalid formatting.
     * @throws RuntimeException
     *             Properties file doesn't exists or invalid path.
     * @return propertyToFill - property instance after all logic in method
     */
    private Properties loadDataTo(String pathName, Properties propertyToFill)
    {
        Class<?> type = getClass();
        if (pathName != null)
        {
            InputStream inputStream = type.getResourceAsStream(pathName);
            if (inputStream == null)
            {
                throw new RuntimeException(NOT_EXIST + pathName);
            }
            try
            {
                propertyToFill.load(inputStream);
            }
            catch (IOException e)
            {
                throw new IllegalArgumentException(INVALID_FORMAT + pathName);
            }
        }
        return propertyToFill;
    }

    /**
     * Gets singleton instance property value by the key.
     * 
     * @param key;
     * @return String property.
     */
    public static String getProviderProperty(String key)
    {
        String property = getDataProvider().propertiesInstance.getProperty(key);
        return property;
    }

    public static String getNewSingletonProviderProperty(String key)
    {
        String property = getNewSingleDataProvider().propertiesInstance.getProperty(key);
        return property;
    }

    /**
     * Gets properties of singleton.
     *
     * @return Properties propertiesProvider.
     */
    public static Properties getProviderProperties()
    {
        return getDataProvider().propertiesInstance;
    }

    /**
     * Returns the singleton instance of DataProvider class
     */
    static public DataProvider getDataProvider()
    {
        synchronized (DataProvider.class)
        {
            if (dataProvider == null)
            {
                dataProvider = new DataProvider();
            }
        }
        return dataProvider;
    }

    /**
     * Warning: that method will return new singleton instance. Do not use
     * method in any purpose, only for needs of unit tests. Returns the NEW
     * singleton instance of DataProvider class
     */
    static public DataProvider getNewSingleDataProvider()
    {
        synchronized (DataProvider.class)
        {
            if (dataProvider == null)
            {
                dataProvider = new DataProvider();
            }
        }
        return new DataProvider();
    }

    /**
     * Field contains instance of property instance. Can contain one property
     * instance if not default file or two property instances if both files
     * exist. Or it contains empty property instance if no one property loaded
     * properly.
     */
    private Properties propertiesInstance;

    /**
     * Singleton instance of data provider class
     */
    static private DataProvider dataProvider;
    /** System property which defines default file with settings */
    static public final String DEFAULT_FILE = "default.file";
    /** System property which defines second file with settings */
    static public final String SECOND_FILE = "second.file";
    /** Fields for error messages */
    static private final String INVALID_FORMAT = "Invalid formatting of properties file located by path: ";
    static private final String NOT_EXIST = "No property file found by path:  ";
}
