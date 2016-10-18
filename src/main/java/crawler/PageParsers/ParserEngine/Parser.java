package crawler.PageParsers.ParserEngine;

import crawler.product.Product;

import java.util.*;

public abstract class Parser {

    protected Map<String, String> webPages;
    private Set<Product> products = new HashSet<Product>();
    protected static final String prefix = "http://www.burlingtoncoatfactory.com/burlingtoncoatfactory/";

    public void setWebPages(Map<String, String> webPages) {
        this.webPages = webPages;
    }

    public abstract Product parsePage(String url, String webPage) throws Exception; // To be defined in implementations

    public Set<Product> parseProducts() {

        if (this.webPages != null) {

            for (String url : this.webPages.keySet()) {
                try {
                    products.add(parsePage(url, webPages.get(url))); // url, web page
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return this.products;
        } else {

            System.out.println("Contents (webPages) Map not initialized. Use the Setter method to set contents");
            return null;
        }
    }

    public abstract List<String> parseLinks(String xpath);
}
