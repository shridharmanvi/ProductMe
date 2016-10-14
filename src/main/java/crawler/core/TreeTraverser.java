package crawler.core;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class TreeTraverser {
    // Read the super xpath for this main category and traverse to end page
    private String client;
    Set<String> leafNodes = new HashSet<>();
    Properties props;


    public TreeTraverser(String client){
        this.client = client;
        this.props = new LoadParser(this.client).getSuperXPaths();
    }

    public Properties getProps(){
        return this.props;
    }

}
