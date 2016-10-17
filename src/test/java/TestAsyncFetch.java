import crawler.PageParsers.BurlingtonParser;
import crawler.core.AsyncFetch;
import crawler.core.LoadConfig;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class TestAsyncFetch {

    @Test
    public void testAsyncFetch() {

        Set<String> urls = new HashSet<String>();
        Set<String> contents;

        urls.add("http://www.burlingtoncoatfactory.com/burlingtoncoatfactory/Men/Activewear/Ohio-State-Buckeyes-Fleece-Lined-Sweatshirt-w-Hood-460724012.aspx?h=57367%2c63236");
        urls.add("http://www.burlingtoncoatfactory.com/burlingtoncoatfactory/Men/Activewear/Drawstring-Joggers-w-Contrast-Pocket-Trim-460864846.aspx?h=57367%2c63236");
        urls.add("http://www.burlingtoncoatfactory.com/burlingtoncoatfactory/Men/Men-s-Coats-Jackets/Men-s-Ski-Active-Jackets/Black-Soft-Shell-Jacket-Big-Tall-867216426.aspx?h=57367%2c63236");

        System.out.println(urls.size());

        AsyncFetch fetch = new AsyncFetch(urls);
        fetch.fetchPages();
        // contents = fetch.getAllPagesContents();
        // System.out.println(contents.size());
    }

    @Test
    public void testSelectorsLoad() {
        // Properties properties = new LoadConfig("burlington").getConfig();
        // System.out.println(properties.getProperty("urls"));
    }

    @Test
    public void testBurlingtonParser() {
        BurlingtonParser burlingtonParser = new BurlingtonParser(new HashMap<String, String>());
    }

    @Test
    public void testTreeTraverser() {
        Properties properties = LoadConfig.getConfig();
        System.out.println(properties);
    }
}
