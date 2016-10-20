package crawler.PageParsers;

import crawler.PageParsers.ParserEngine.Parser;
import crawler.product.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.xsoup.Xsoup;

import java.util.List;

public class IteratorExtractorParser extends Parser {
    public Product parsePage(String url, String webPage) throws Exception {
        return null;
    }

    public List<String> parseLinks(String xpath) {
        return null;
    }

    public String parseIterator(String xPath, String webPage) {
        Document document = Jsoup.parse(webPage);
        return String.valueOf(Xsoup.compile(xPath).evaluate(document).get());
    }
}
