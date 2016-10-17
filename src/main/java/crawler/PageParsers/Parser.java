package crawler.PageParsers;

import crawler.product.Product;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Parser {

    private Map<String, String> webPages;
    private Set<Product> products;

    Parser() {}

    Parser(Map<String, String> webPages) {
        this.webPages = webPages;
        this.products = new HashSet<Product>();
    }

    public Set<Product> parseProducts() {
        for (String url : this.webPages.keySet()) {
            try {
                products.add(parsePage(url, webPages.get(url))); // url, web page
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.products;
    }

    abstract Product parsePage(String url, String webPage) throws Exception;

    public Set<Product> getProducts() {
        return products;
    }

}
