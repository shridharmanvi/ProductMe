package crawler.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncFetch {

    private Set<String> urls;
    private Set<String> allPagesContents = new HashSet<String>();
    private List<Future<String>> futures;

    public AsyncFetch(Set<String> urls) {
        this.urls = urls;
        this.futures = new ArrayList<Future<String>>();
    }

    public Set<String> getAllPagesContents() {
        return allPagesContents;
    }

    public void fetchPages() {
        ExecutorService service = Executors.newFixedThreadPool(10); // Change number of threads here.

        long start = System.currentTimeMillis();

        for (final String url : urls) {
            futures.add(service.submit(new FetchExecutor(url)));
        }

        long mid = System.currentTimeMillis();

        try {
            for (Future<String> result : futures) {
                allPagesContents.add(result.get());
            }

        } catch (Exception ignored) {

        }
        long end = System.currentTimeMillis();

        System.out.println("Submission time: " + (mid - start) + " milli seconds");
        System.out.println("Total time: " + (end - start) + " milli seconds");
    }


}


