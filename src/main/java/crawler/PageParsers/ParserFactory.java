package crawler.PageParsers;

public class ParserFactory {
    // Builder factory to build any type of Parser type

    public static Parser getParser(String parserType) {
        if (parserType.equalsIgnoreCase("burlington")) {
            return new BurlingtonParser();
        } else if (parserType.equalsIgnoreCase("nascar")) {
            return new NascarParser();
        }
        throw new IllegalArgumentException(parserType + " isn't valid");
    }

}
