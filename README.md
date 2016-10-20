# ProductMe
A large scale generic, fast, efficient web crawler to parse items from any e-commerce website.

The user needs to define whats called as super-xpaths in the properties file and pass it as arguments to crawl any e-commerce websites which do not need authentication. The core functionality of a web crawler is completely dcoupled from the client and hence the generic behavior. 

## What is a super-xpath?
super-xpath is a way of instructing the crawler to reach the leaf nodes (product pages) from the root of the website or a sub category page.   
Eg: category_url||xpath1||xpath2||xpath3
    This super-xpath instructs the crawler to start from the category_url, find all the links on the response page with xpath1, find all the links on these child pages with xpath2 and so on untill it hits the leaf nodes. These leaf urls are pages which we are interested in as these posses the information that we desire to scrape.

## Async behaviour
The app sends several async http requests to the client to fetch the content. This is implemented using executor service. Once all of the ontent is received, the parser then parses the contents of the responses using xpath defined in the properties file. The products are then written to an external file.

NOTE: Make sure your IP is whitlisted by the client before running this app. The app makes several async http requests resulting in bot behaviour and hence your IP may be blacklisted for multiple websites. 
