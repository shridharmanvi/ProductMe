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

    private void traverserPlanner(String super_path) {

    }

    private void traverse(String xpath) {

    }

    public Set<String> getLeafNodes() {
        return leafNodes;
    }
}
