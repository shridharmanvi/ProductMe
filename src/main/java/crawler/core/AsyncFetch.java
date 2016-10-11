package crawler.core;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncFetch {

    private Set<String> urls;
    private Set<HashMap<String, String>> allPagesContents = new HashSet<HashMap<String, String>>(); // <url, content>
    private List<Future<HashMap<String, String>>> futures;

    public AsyncFetch(Set<String> urls) {
        this.urls = urls;
        this.futures = new ArrayList<Future<HashMap<String, String>>>();
    }

    public Set<HashMap<String, String>> getAllPagesContents() {
        return allPagesContents;
    }

    public void fetchPages() {
        ExecutorService fetchService = Executors.newFixedThreadPool(10); // Change number of threads here.

        long start = System.currentTimeMillis();

        for (final String url : urls) {
            futures.add(fetchService.submit(new FetchExecutor(url)));
        }

        long mid = System.currentTimeMillis();

        try {
            for (Future<HashMap<String, String>> result : futures) {
                allPagesContents.add(result.get());
            }

        } catch (Exception ignored) {

        } finally {
            fetchService.shutdown();
        }
        long end = System.currentTimeMillis();

        System.out.println("Submission time: " + (mid - start) + " milli seconds");
        System.out.println("Total time: " + (end - start) + " milli seconds");
    }


}


