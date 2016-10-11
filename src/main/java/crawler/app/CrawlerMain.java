package crawler.app;

import crawler.core.AsyncFetch;
import crawler.core.PageParser;
import crawler.product.Product;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CrawlerMain {

    public static String outputFile = "";


    public static void main(String[] args) {

        Set<String> urls = new HashSet<String>();
        Set<HashMap<String, String >> contents;
        Set<Product> products;

        //Write code to fetch all leaf nodes for a category


        urls.add("http://www.burlingtoncoatfactory.com/burlingtoncoatfactory/Men/Activewear/Ohio-State-Buckeyes-Fleece-Lined-Sweatshirt-w-Hood-460724012.aspx?h=57367%2c63236");
        urls.add("http://www.burlingtoncoatfactory.com/burlingtoncoatfactory/Men/Activewear/Drawstring-Joggers-w-Contrast-Pocket-Trim-460864846.aspx?h=57367%2c63236");
        urls.add("http://www.burlingtoncoatfactory.com/burlingtoncoatfactory/Men/Men-s-Coats-Jackets/Men-s-Ski-Active-Jackets/Black-Soft-Shell-Jacket-Big-Tall-867216426.aspx?h=57367%2c63236");
        urls.add("http://www.burlingtoncoatfactory.com/burlingtoncoatfactory/Men/Sherpa-Lined-Tech-Parka-w-Hood-810055634.aspx?h=58378,57368");

        AsyncFetch asyncFetch = new AsyncFetch(urls);
        asyncFetch.fetchPages();
        contents = asyncFetch.getAllPagesContents();

        PageParser pageParser = new PageParser(contents);
        products = pageParser.parseProducts();

        for (Product product:products){
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Cost: " + product.getCost());
            System.out.println("Clearance cost: " + product.getClearanceCost());
            System.out.println("URL: " + product.getUrl());
            System.out.println("Image url: " + product.getPictureUrl());
        }

    }

}
