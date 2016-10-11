package crawler.core;

import java.util.HashMap;
import java.util.Map;

public class LoadParser {

    // Responsible for loading all xPaths/Css selectors from resource file

    private Map<String, String> selectors;

    public LoadParser() {
        selectors = new HashMap<String, String>();
        loadFile();
    }

    private void loadFile() {
        // Read resource file and load the hashmap
        selectors.put("name", "Value");
    }

    public Map<String, String> getSelectors() {
        return selectors;
    }
}
