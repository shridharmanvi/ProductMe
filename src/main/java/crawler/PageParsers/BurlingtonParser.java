package crawler.PageParsers;

import com.sun.org.apache.xpath.internal.XPath;
import com.sun.org.apache.xpath.internal.XPathFactory;
import crawler.product.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPathConstants;
import java.util.Map;

public class BurlingtonParser extends Parser {

    public BurlingtonParser(Map<String, String> webPages) {
        super(webPages);
    }

    @Override
    public Product parsePage(String url, String webPage) throws Exception {
        Document doc = Jsoup.parse(webPage);
        Product product = new Product();

        product.setName(doc.select(".product-details-title").text());
        product.setClearanceCost(doc.select(".textPrice").text());
        product.setCost(doc.select(".textPriceCompare").text());
        product.setId(doc.select("#ctl03_MainContentArea_ctl00_ctl00_ctl00_ProductDisplay_ProductDescriptionModule_LblItemNumber").text().split("#")[1]);
        product.setUrl(url);

        Elements img = doc.select("#productMainImage");
        product.setPictureUrl(img.attr("src"));
        return product;
    }
}
