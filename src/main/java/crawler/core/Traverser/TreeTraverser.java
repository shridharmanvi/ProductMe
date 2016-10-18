package crawler.core.Traverser;

import crawler.core.XpathEngine.SuperXpath;

import java.util.HashSet;
import java.util.Set;

public class TreeTraverser {
    // Read the super xpath for this main category and traverse to end page (leaves)

    private Set<String> leafNodes = new HashSet<String>();
    private SuperXpath superXpath;

    public TreeTraverser(SuperXpath superXpath) {
        this.superXpath = superXpath;
    }

    private void traverserPlanner() {
        // AsyncGet the url from superXpath object
        // Set<urls> subCategories= PageParser(Xpath)
        //

    }

    private void traverse() {

    }

    public Set<String> getLeafNodes() {
        return leafNodes;
    }
}
