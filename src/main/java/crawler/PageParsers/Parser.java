package crawler.PageParsers;

import crawler.product.Product;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Parser {

    private Map<String, String> webPages;
    private Set<Product> products = new HashSet<Product>();

    public void setWebPages(Map<String, String> webPages) {
        this.webPages = webPages;
    }

    abstract Product parsePage(String url, String webPage) throws Exception; // To be defined in implementations

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
}
