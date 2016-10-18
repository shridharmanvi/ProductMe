package crawler.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadConfig {
    // Singleton class for config object
    // Private constructor to implement singleton behavior

    private LoadConfig() {
    }

    private static Properties properties = null;

    public static Properties loadFile(String client) {
        String properties_file = client + ".properties";

        InputStream inputStream = LoadConfig.class.getClassLoader().getResourceAsStream(properties_file);

        if (inputStream != null) {
            try {
                if (properties == null) {
                    properties = new Properties();
                    properties.load(inputStream);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return properties;
    }

    public static Properties getConfig() {
        return properties;
    }
}
