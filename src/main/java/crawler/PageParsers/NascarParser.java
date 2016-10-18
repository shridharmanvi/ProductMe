package crawler.PageParsers;

import crawler.PageParsers.ParserEngine.Parser;
import crawler.product.Product;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class NascarParser extends Parser {

    @Override
    public Product parsePage(String url, String webPage) throws Exception {
        throw new UnsupportedOperationException("Not implemented yet!!");
    }

    public List<String> parseLinks(String xpath) {
        throw new NotImplementedException();
    }

}
