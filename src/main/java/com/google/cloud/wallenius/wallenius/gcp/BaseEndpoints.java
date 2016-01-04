package com.google.cloud.wallenius.wallenius.gcp;

import com.google.cloud.wallenius.wallenius.gcp.beans.MetadataResponse;
import com.google.cloud.wallenius.wallenius.gcp.beans.SillyBean;
import com.google.cloud.wallenius.wallenius.gcp.httpclient.HttpClient;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wallenius
 */
public class BaseEndpoints {
    
    private final HttpClient http;
    private final String METADATA_URL = "http://metadata.google.internal/computeMetadata/v1/?recursive=true";
    
    public BaseEndpoints(HttpClient injectedClient) {
        this.http = injectedClient;
    }
    
    private Map<String, String> createMetadataHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Metadata-Flavor", "Google");
        return headers;
    }
    
    public SillyBean getIt() {
        
        String response = http.getRequest(METADATA_URL, this.createMetadataHeaders());
        return new SillyBean(1337, response);
    }
    
    public SillyBean roundTrip(SillyBean s) {
        return s;
    }

    public MetadataResponse instanceMetadata() {
        Gson gson = new Gson();
        String response = http.getRequest(METADATA_URL, this.createMetadataHeaders());
        return gson.fromJson(response, MetadataResponse.class);
    }
    
}
