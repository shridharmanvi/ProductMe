package crawler.PageParsers.ParserEngine;

import crawler.PageParsers.BurlingtonParser;
import crawler.PageParsers.LinksParser;
import crawler.PageParsers.NascarParser;

public class ParserFactory {
    // Builder factory to build any type of Parser type

    public static Parser getParser(String parserType) {
        if (parserType.equalsIgnoreCase("burlington")) {
            return new BurlingtonParser();
        } if (parserType.equalsIgnoreCase("nascar")) {
            return new NascarParser();
        }
        else if (parserType.equalsIgnoreCase("getlinks")){
            return new LinksParser();
        }
        throw new IllegalArgumentException(parserType + " isn't valid");
    }

}
