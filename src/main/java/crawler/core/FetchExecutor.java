package crawler.core;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class FetchExecutor implements Callable<HashMap<String, String>> {
    private CloseableHttpClient client;

    private String url;

    public FetchExecutor(String url) {
        this.client = HttpClients.createDefault();
        this.url = url;
    }

    public HashMap<String, String> call() throws Exception {
        if (url != null && !url.equals("")) {

            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            try {
                HashMap<String, String> content = new HashMap<String, String>();

                if (entity != null) {

                    InputStream instream = entity.getContent();
                    content.put(url, IOUtils.toString(instream, "UTF-8"));

                    return content;
                } else {
                    return new HashMap<String, String>();
                }
            } finally {

                try {
                    response.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            return null;
        }
    }
}
