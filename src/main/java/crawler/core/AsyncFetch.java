package crawler.core;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncFetch {

    private Set<String> urls;

    private Map<String,Future<String>> tasks = new HashMap<>();
    private Map<String,String> results = new HashMap<>();

    public AsyncFetch(Set<String> urls) {
        this.urls = urls;
    }

    public Map<String, String> getAllPagesContents() {
        return results;
    }

    public void fetchPages() {
        ExecutorService fetchService = Executors.newFixedThreadPool(10); // Change number of threads here.

        long start = System.currentTimeMillis();

        for (final String url : urls) {
            tasks.put(url, fetchService.submit(new FetchExecutor(url)));
        }

        long mid = System.currentTimeMillis();

        try {
            for (String url: tasks.keySet()) {
                Future<String> task = tasks.get(url);
                results.put(url, task.get());
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


