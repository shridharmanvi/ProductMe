package crawler.PageParsers;

import crawler.product.Product;

import java.util.Map;

public class NascarParser extends Parser {

    public NascarParser(Map<String, String> webPages) {
        super(webPages);
    }


    @Override
    Product parsePage(String url, String webPage) throws Exception {
        return null;
    }
}
