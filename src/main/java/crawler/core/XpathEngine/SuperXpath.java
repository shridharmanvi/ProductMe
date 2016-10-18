package crawler.core.XpathEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuperXpath {
    //  SuperXpath parser

    private String superXpath;
    private String url;
    private List<String> levels = new ArrayList<String>();

    public SuperXpath(String superXpath) {
        this.superXpath = superXpath;
        parseSuperXpaths();
    }

    public void parseSuperXpaths() {
        url = superXpath.split("\t")[0];
        levels.addAll(Arrays.asList(superXpath.split("\t")[1].split(",")));
    }

    public String getSuperXpath() {
        return superXpath;
    }

    public String getUrl() {
        return url;
    }

    public List<String> getLevels() {
        return levels;
    }
}
