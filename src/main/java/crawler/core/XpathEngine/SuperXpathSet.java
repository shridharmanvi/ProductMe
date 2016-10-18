package crawler.core.XpathEngine;

import crawler.core.LoadConfig;

import java.util.HashSet;
import java.util.Set;

public class SuperXpathSet {

    private Set<SuperXpath> superXpathSet = new HashSet<SuperXpath>();

    public SuperXpathSet() {
        buildSet();
    }

    public void buildSet() {
        for (Object property : LoadConfig.getConfig().keySet()) {
            if (String.valueOf(property).startsWith("super_paths")) {
                superXpathSet.add(new SuperXpath(LoadConfig.getConfig().getProperty(String.valueOf(property))));
            }
        }
    }

    public Set<SuperXpath> getSuperXpathSet() {
        return superXpathSet;
    }
}
