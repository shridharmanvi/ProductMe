package crawler.main;

import java.util.HashSet;
import java.util.Set;

class GetLinks {
    // Fetches a page and returns links according to the xpath
    private String xpath;
    private Set<String> links;

    public GetLinks(String xpath) {
        this.xpath = xpath;
        links = new HashSet<String>();
    }

    private Set<String> fetchLinks() {

        return links;
    }
}
