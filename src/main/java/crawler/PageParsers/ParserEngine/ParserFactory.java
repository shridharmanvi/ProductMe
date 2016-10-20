package crawler.PageParsers.ParserEngine;

import crawler.PageParsers.BurlingtonParser;
import crawler.PageParsers.IteratorExtractorParser;
import crawler.PageParsers.LinksParser;
import crawler.PageParsers.NascarParser;

public class ParserFactory {
    // Builder factory to build any type of Parser type

    public static Parser getParser(String parserType) {
        if (parserType.equalsIgnoreCase("burlington")) {
            return new BurlingtonParser();
        }
        if (parserType.equalsIgnoreCase("nascar")) {
            return new NascarParser();
        }
        if (parserType.equalsIgnoreCase("getlinks")){
            return new LinksParser();
        }
        else  if (parserType.equalsIgnoreCase("iteratorExtractor")){
            return new IteratorExtractorParser();
        }
        throw new IllegalArgumentException(parserType + " isn't valid");
    }

}
