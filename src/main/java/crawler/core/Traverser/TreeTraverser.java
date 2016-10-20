package crawler.core.Traverser;

import crawler.PageParsers.IteratorExtractorParser;
import crawler.PageParsers.ParserEngine.Parser;
import crawler.PageParsers.ParserEngine.ParserFactory;
import crawler.core.DataExchangeHandler.AsyncFetch;
import crawler.core.LoadConfig;
import crawler.core.XpathEngine.SuperXpath;

import java.util.*;

public class TreeTraverser {
    // Read the super xpath for this main category and traversePlanner to end page (leaves)

    private Set<String> leafNodes = new HashSet<String>();
    private SuperXpath superXpath;
    private Set<List<String>> collection = new HashSet<List<String>>();

    public TreeTraverser(SuperXpath superXpath) {
        this.superXpath = superXpath;
        traversePlanner();
    }

    private void traversePlanner() {
        Parser linksParser = ParserFactory.getParser("getlinks");
        List<String> paths = this.superXpath.getLevels();

        for (int i = 0; i < paths.size(); i++) {
            if (i == 0) {
                Set<String> urls = new HashSet<String>();
                urls.add(this.superXpath.getUrl());
                collection.add(traverse1(urls, linksParser, paths, i));
            } else {
                @SuppressWarnings("unchecked")
                ArrayList<String> poi = (ArrayList<String>) collection.toArray()[i - 1];

                for (String url : poi) {

                    // expandedUrl is the main url that can be used
                    String expandedUrl = getExpandedUrls(url);
                    Set<String> expandedUrls = new HashSet<String>();
                    expandedUrls.add(expandedUrl);
                    leafNodes.addAll(traverse1(expandedUrls, linksParser, paths, i)); // confirm
                }

                System.out.println(leafNodes);
                // Set<String> urlss = new HashSet<String>(poi);
                // collection.add(traverse1(urlss, linksParser, paths, i));
            }
        }

        for (int i = 0; i < collection.size(); i++) {
            System.out.println(collection.toArray()[i]);
        }
    }

    private List<String> traverse1(Set<String> urls, Parser linksParser, List<String> paths, int i) {
        Map<String, String> contents;
        AsyncFetch fetch = new AsyncFetch(urls);

        fetch.fetchPages();
        contents = fetch.getAllPagesContents();
        linksParser.setWebPages(contents);

        return linksParser.parseLinks(paths.get(i));
    }

    private String getExpandedUrls(String url) {
        String iterations_xpath = String.valueOf(LoadConfig.getConfig().getProperty("iterations.xpath"));
        String expandedUrls;
        IteratorExtractorParser iteratorExtractorParser = (IteratorExtractorParser) ParserFactory.getParser("iteratorExtractor");


        Set<String> urll = new HashSet<String>();
        Map<String, String> contents;

        urll.add(url);
        AsyncFetch asyncFetch = new AsyncFetch(urll);
        asyncFetch.fetchPages();

        contents = asyncFetch.getAllPagesContents();

        Map.Entry<String, String> onlyWebPage = contents.entrySet().iterator().next();
        String iterations = iteratorExtractorParser.parseIterator(iterations_xpath, onlyWebPage.getValue());
        expandedUrls = url + "#pg=" + iterations + "&dpp=true";

        return expandedUrls;
    }

    public Set<String> getLeafNodes() {
        return leafNodes;
    }
}
