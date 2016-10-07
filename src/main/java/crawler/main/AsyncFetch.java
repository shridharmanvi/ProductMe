package crawler.main;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncFetch {
    private Set<String> urls;
    private Set<String> allPagesContents = new HashSet<String>();
    private CloseableHttpClient client;
    private HttpGet httpGet;
    private CloseableHttpResponse response;
    private HttpEntity entity;
    private Future<String> futures;

    public AsyncFetch(Set<String> urls) {
        this.urls = urls;
    }

    public Set<String> getAllPagesContents() {
        return allPagesContents;
    }

    public void fetchPages() {
        ExecutorService service = Executors.newFixedThreadPool(20);

        System.out.println("Starting function...");
        for (final String url : urls) {

            Future<String> result = service.submit(new Callable<String>() {
                public String call() throws Exception {
                    client = HttpClients.createDefault();
                    httpGet = new HttpGet(url);
                    response = client.execute(httpGet);
                    entity = response.getEntity();
                    try {

                        if (entity != null) {
                            InputStream instream = entity.getContent();
                            return IOUtils.toString(instream, "UTF-8");

                        } else {
                            return null;
                        }
                    } finally {

                        try {
                            response.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            });
            System.out.println("Just before calling get..");
            try {
                allPagesContents.add(result.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("After calling get...");
        }

        service.shutdown();
    }

}
