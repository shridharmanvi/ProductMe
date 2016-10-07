import crawler.main.AsyncFetch;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TestAsyncFetch {

    @Test
    public void testAsyncFetch(){

        Set<String> urls = new HashSet<String>();
        urls.add("http://www.burlingtoncoatfactory.com/burlingtoncoatfactory/Men/Activewear/Ohio-State-Buckeyes-Fleece-Lined-Sweatshirt-w-Hood-460724012.aspx?h=57367%2c63236");
        urls.add("http://www.burlingtoncoatfactory.com/burlingtoncoatfactory/Men/Activewear/Drawstring-Joggers-w-Contrast-Pocket-Trim-460864846.aspx?h=57367%2c63236");
        urls.add("http://www.burlingtoncoatfactory.com/burlingtoncoatfactory/Men/Men-s-Coats-Jackets/Men-s-Ski-Active-Jackets/Black-Soft-Shell-Jacket-Big-Tall-867216426.aspx?h=57367%2c63236");

        AsyncFetch fetch = new AsyncFetch(urls);
        fetch.fetchPages();
    }
}
