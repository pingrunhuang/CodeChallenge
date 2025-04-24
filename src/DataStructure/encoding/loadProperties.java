package DataStructure.encoding;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class loadProperties {
    public static String load(String propertyPath, String propertyName) throws IOException {
        InputStream ios = new FileInputStream(propertyPath);
        Properties properties = new Properties();
        properties.load(ios);
        ios.close();

        String value = properties.getProperty(propertyName);
        // the second value is the actual encoding type of the property file.
        return new String(value.getBytes("iso-8859-1"), "utf-8");
    }
}
