package crawler.PageParsers;

import crawler.PageParsers.ParserEngine.Parser;
import crawler.product.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import us.codecraft.xsoup.Xsoup;

import java.util.ArrayList;
import java.util.List;

public class LinksParser extends Parser {

    @Override
    public Product parsePage(String url, String webPage) throws Exception {
        throw new NotImplementedException();
    }

    @Override
    public List<String> parseLinks(String xpath) {
        List<String> links = new ArrayList<String>();
        for (String url : webPages.keySet()) {
            Document doc = Jsoup.parse(webPages.get(url));
            links = Xsoup.compile(xpath).evaluate(doc).list();
        }

        // Below loop adds root url prefix if absent
        for (int i = 0; i < links.size(); i++) {
            if (!links.get(i).startsWith(prefix)) {
                String url = links.get(i);
                links.set(i, prefix + url);
            }
        }

        return links;
    }
}
