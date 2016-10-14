package crawler.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadParser {
    // Responsible for loading all xPaths/Css selectors from resource file

    private String client;
    private Properties superXPaths = new Properties();

    public LoadParser(String client) {
        this.client = client;
    }

    private void loadFile() {
        // Read resource file and load the hashmap
        String properties_file = client + ".properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(properties_file);
        if (inputStream != null) {
            try {
                superXPaths.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Properties getSuperXPaths() {
        return superXPaths;
    }
}
