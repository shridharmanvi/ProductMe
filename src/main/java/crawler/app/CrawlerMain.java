package crawler.app;

import crawler.PageParsers.ParserEngine.Parser;
import crawler.PageParsers.ParserEngine.ParserFactory;
import crawler.core.DataExchangeHandler.AsyncFetch;
import crawler.core.LoadConfig;
import crawler.core.Traverser.TreeTraverser;
import crawler.core.XpathEngine.SuperXpath;
import crawler.core.XpathEngine.SuperXpathSet;
import crawler.product.Product;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CrawlerMain {

    public static String outputFile = "";

    public static void main(String[] args) {
        Set<String> leafNodes = new HashSet<String>();
        Map<String, String> contents;
        Set<Product> products;
        String client = args[0];
        LoadConfig.loadFile(client);
        SuperXpathSet superXpathSet = new SuperXpathSet();


        for (SuperXpath superXpath : superXpathSet.getSuperXpathSet()) {
            TreeTraverser treeTraverser = new TreeTraverser(superXpath);

        }

        AsyncFetch asyncFetch = new AsyncFetch(leafNodes);
        asyncFetch.fetchPages();
        contents = asyncFetch.getAllPagesContents();
///////

        Parser pageParser = ParserFactory.getParser(client);
        pageParser.setWebPages(contents);

        products = pageParser.parseProducts();

        for (Product product : products) {
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Cost: " + product.getCost());
            System.out.println("Clearance cost: " + product.getClearanceCost());
            System.out.println("URL: " + product.getUrl());
            System.out.println("Image url: " + product.getPictureUrl());
        }


    }

}
