package crawler.core.Traverser;

import crawler.PageParsers.ParserEngine.Parser;
import crawler.PageParsers.ParserEngine.ParserFactory;
import crawler.core.DataExchangeHandler.AsyncFetch;
import crawler.core.XpathEngine.SuperXpath;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TreeTraverser {
    // Read the super xpath for this main category and traverse to end page (leaves)

    private Set<String> leafNodes = new HashSet<String>();
    private SuperXpath superXpath;

    public TreeTraverser(SuperXpath superXpath) {
        this.superXpath = superXpath;
        traverserPlanner();
    }

    private void traverserPlanner() {

        Map<String, String> contents;
        Set<String> urls = new HashSet<String>();
        urls.add(this.superXpath.getUrl());

        AsyncFetch fetch = new AsyncFetch(urls);
        fetch.fetchPages();
        contents = fetch.getAllPagesContents();

        Parser linksparser = ParserFactory.getParser("getlinks");
        linksparser.setWebPages(contents);
        linksparser.parseLinks(String.valueOf(this.superXpath.getLevels().toArray()[0]));
    }

    private void traverse() {

    }

    public Set<String> getLeafNodes() {
        return leafNodes;
    }
}
