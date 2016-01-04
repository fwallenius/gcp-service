package com.google.cloud.wallenius.wallenius.gcp.httpclient;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author wallenius
 */
public class SimpleHttpClient implements HttpClient {

    final static Logger logger = LoggerFactory.getLogger(SimpleHttpClient.class);
    static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

    @Override
    public String getRequest(String url, Map<String, String> headersMap) {
        try {
            HttpRequestFactory requestFactory
                    = HTTP_TRANSPORT.createRequestFactory((HttpRequest request) -> {
                        request.setLoggingEnabled(true);
                    });

            HttpHeaders headers = new HttpHeaders();
            headers.putAll(headersMap);
            
            HttpRequest request = requestFactory.buildGetRequest(new GenericUrl(url));
            request.setHeaders(headers);
            
            try (InputStream is = request.execute().getContent()) {
                return IOUtils.toString(is, Charset.defaultCharset());
            }
        } catch (IOException ex) {
            logger.error("Error when requesting: " + url, ex);
            throw new HttpException(ex);
        }
    }

    @Override
    public String postRequest(String url, String postBody, Map<String, String> headers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
