package com.google.cloud.wallenius.wallenius.gcp.httpclient;

import java.util.Map;

/**
 *
 * @author wallenius
 */
public interface HttpClient {

    String getRequest(String url, Map<String, String> headers);
    
    String postRequest(String url, String postBody, Map<String, String> headers);
    
}
