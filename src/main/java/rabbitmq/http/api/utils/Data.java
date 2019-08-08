package rabbitmq.http.api.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Data {
    public static String getData(String url, String username, String password) throws IOException {
        //CloseableHttpClient httpClient = HttpClients.createDefault(); //不使用线程池多线程下会有报错，
        CloseableHttpClient httpClient = HttpClientUtils.getHttpClient(); //使用连接池，已加锁
        UsernamePasswordCredentials creds = new UsernamePasswordCredentials(username, password);
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader(BasicScheme.authenticate(creds, "UTF-8", false));
        httpGet.setHeader("Content-Type", "application/json");

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
        } catch (IOException e) {
            System.out.println("time out");
        }

        try {
            if(response == null){
                //throw new NullPointerException("response is NULL");
                return null;
            }
            if ( response.getStatusLine().getStatusCode() != 200) {
                System.out.println("call http api to get rabbitmq data return code: " + response.getStatusLine().getStatusCode() + ", url: " + url);
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity);
            }
        } finally {
            if (response != null)
                response.close();
        }

        return StringUtils.EMPTY;
    }
}
