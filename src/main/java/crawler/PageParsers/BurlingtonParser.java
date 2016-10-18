package crawler.PageParsers;

import crawler.PageParsers.ParserEngine.Parser;
import crawler.core.LoadConfig;
import crawler.product.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import us.codecraft.xsoup.Xsoup;

import java.util.List;

public class BurlingtonParser extends Parser {

    @Override
    public Product parsePage(String url, String webPage) throws Exception {
        Document doc = Jsoup.parse(webPage);
        Product product = new Product();

        product.setUrl(url);
        product.setName(Xsoup.compile(LoadConfig.getConfig().getProperty("product.name"))
                .evaluate(doc).get());
        product.setClearanceCost(Xsoup.compile(LoadConfig.getConfig().getProperty("product.clearence_cost"))
                .evaluate(doc).get());
        product.setCost(Xsoup.compile(LoadConfig.getConfig().getProperty("product.cost"))
                .evaluate(doc).get());
        product.setPictureUrl(Xsoup.compile(LoadConfig.getConfig().getProperty("product.image_url"))
                .evaluate(doc).get());
        product.setId(Xsoup.compile(LoadConfig.getConfig().getProperty("product.id"))
                .evaluate(doc).get().split("#")[1]);

        return product;
    }

    public List<String> parseLinks(String xpath) {
        throw new NotImplementedException();
    }

}
