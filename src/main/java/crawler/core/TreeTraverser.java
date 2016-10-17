package crawler.core;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreeTraverser {
    // Read the super xpath for this main category and traverse to end page

    Set<String> leafNodes = new HashSet<String>();
    String superPaths = LoadConfig.getConfig().getProperty("super_paths");

    public TreeTraverser() {
        System.out.println(superPaths);
    }

    private void traverserPlanner(String super_path) {

    }

    private void traverse(String xpath) {

    }

}
