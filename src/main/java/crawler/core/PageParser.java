package crawler.core;

import crawler.product.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PageParser {

    // Accepts a set of webPages (Strings) and parses them to set of Product objects
    // Usage: new PageParser(webPages).parseProducts()

    private Set<HashMap<String, String>> webPages;
    private Set<Product> products;

    public PageParser(){}

    public PageParser(Set<HashMap<String, String>> webPages) {
        this.webPages = webPages;
        products = new HashSet<Product>();
    }

    public Set<Product> parseProducts() {

        for (HashMap<String, String> webPage : this.webPages) {
            try {
                String url = String.valueOf(webPage.keySet().toArray()[0]);
                products.add(parsePage(url, webPage.get(url))); // url, web page

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return this.products;
    }

    public void parsePage(){

    }

    private Product parsePage(String url, String webPage) throws Exception {

        Product product = new Product();
        Document doc = Jsoup.parse(webPage);

        product.setName(doc.select(".product-details-title").text());
        // product.setClearanceCost(doc.select(".price").text());
        product.setClearanceCost(doc.select(".textPrice").text());
        product.setCost(doc.select(".textPriceCompare").text());
        product.setId(doc.select("#ctl03_MainContentArea_ctl00_ctl00_ctl00_ProductDisplay_ProductDescriptionModule_LblItemNumber").text().split("#")[1]);
        product.setUrl(url);

        Elements img = doc.select("#productMainImage");
        product.setPictureUrl(img.attr("src"));

        return product;
    }

    protected void getLinks(){

    }

}
