package crawler.app;

import crawler.PageParsers.BurlingtonParser;
import crawler.PageParsers.NascarParser;
import crawler.PageParsers.Parser;
import crawler.core.AsyncFetch;
import crawler.core.LoadConfig;
import crawler.core.TreeTraverser;
import crawler.product.Product;

import java.util.*;

public class CrawlerMain {
    public static String outputFile = "";

    private static Map<String, Parser> parserMap = new HashMap<String, Parser>();


    public static void main(String[] args) {

        Set<String> leafNodes = new HashSet<String>();
        Map<String, String> contents;
        Set<Product> products;
        Set<String> baseUrls = new HashSet<String>();
        String client = args[0];
        LoadConfig.loadFile(client);


        // main category
        baseUrls.add("http://www.burlingtoncoatfactory.com/burlingtoncoatfactory/Coats-58378.aspx");

        TreeTraverser traverser = new TreeTraverser();
        // Submit baseUrls to TreeTraversal along with the superXpath.
        // leafNodes = links.traverseToLeaf();


        leafNodes.add("http://www.burlingtoncoatfactory.com/burlingtoncoatfactory/Men/Activewear/Drawstring-Joggers-w-Contrast-Pocket-Trim-460864846.aspx?h=57367%2c63236");
        leafNodes.add("http://www.burlingtoncoatfactory.com/burlingtoncoatfactory/Men/Men-s-Coats-Jackets/Men-s-Ski-Active-Jackets/Black-Soft-Shell-Jacket-Big-Tall-867216426.aspx?h=57367%2c63236");
        leafNodes.add("http://www.burlingtoncoatfactory.com/burlingtoncoatfactory/Men/Sherpa-Lined-Tech-Parka-w-Hood-810055634.aspx?h=58378,57368");


        AsyncFetch asyncFetch = new AsyncFetch(leafNodes);
        asyncFetch.fetchPages();
        contents = asyncFetch.getAllPagesContents();

        parserMap.put("burlington", new BurlingtonParser(contents));
        parserMap.put("nascar", new NascarParser(contents));

        crawler.PageParsers.Parser pageParser = parserMap.get(client);

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
