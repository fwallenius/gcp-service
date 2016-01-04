package com.google.cloud.wallenius.wallenius.gcp;

import com.google.cloud.wallenius.wallenius.gcp.beans.MetadataResponse;
import com.google.cloud.wallenius.wallenius.gcp.beans.SillyBean;
import com.google.cloud.wallenius.wallenius.gcp.httpclient.HttpClient;
import com.google.cloud.wallenius.wallenius.gcp.httpclient.SimpleHttpClient;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import static org.mockito.Mockito.*;

/**
 *
 * @author wallenius
 */
public class BaseEndpointsTest implements HttpClient {

    @Test
    public void testGetIt() {

        HttpClient client = mock(HttpClient.class);
        when(client.getRequest(any(String.class), any(Map.class))).thenReturn(FAKE_META_RESP);

        BaseEndpoints instance = new BaseEndpoints(client);

        SillyBean expResult = new SillyBean(1337, FAKE_META_RESP);
        SillyBean result = instance.getIt();
        assertEquals(expResult, result);
    }

    @Test
    public void ensureGoogleHeaderIsSet() {

        BaseEndpoints instance = new BaseEndpoints(this);
        
        this.mockResponse = FAKE_META_RESP;
        SillyBean expResult = new SillyBean(1337, FAKE_META_RESP);
        SillyBean result = instance.getIt();
        
        assertEquals(1, lastHeaders.keySet().size());
        assertEquals(lastHeaders.get("Metadata-Flavor"), "Google");
    }
    
    @Test
    public void ensureRightMetadataUrl() {
        String expected = "http://metadata.google.internal/computeMetadata/v1/?recursive=true";
        
        BaseEndpoints instance = new BaseEndpoints(this);
        
        Assert.assertNull(this.lastUrl);
        instance.getIt();
        assertEquals(expected, lastUrl);
    }
    
    @Test
    public void successfulMetadataFetch() {
        
        HttpClient client = mock(HttpClient.class);
        when(client.getRequest(any(String.class), any(Map.class))).thenReturn(FAKE_META_RESP);
        BaseEndpoints instance = new BaseEndpoints(client);
        
        MetadataResponse resp = instance.instanceMetadata();
        
        System.out.println("Response: " + resp);
        
        assertEquals(resp.getInstance().getHostname(), "w-java.c.cloud-tam-playground.google.com.internal");
    }
    
//    @Test
//    public void ensureExceptionTranslation() {
//        
//        HttpClient client = mock(HttpClient.class);
//        BaseEndpoints instance = new BaseEndpoints(client);
//        
//        when(client.getRequest(anyObject(), anyObject())).thenThrow(new IOException("Mock error"));
//    }

    @Test
    public void testRoundTrip() {
        SillyBean s = new SillyBean(1337, "Fredrik");

        BaseEndpoints instance = new BaseEndpoints(new SimpleHttpClient());
        SillyBean expResult = new SillyBean(1337, "Fredrik");
        SillyBean result = instance.roundTrip(s);
        assertEquals(expResult, result);
    }

    final static String FAKE_META_RESP = "{\"instance\":{\"attributes\":{},\"cpuPlatform\":\"Intel Haswell\",\"description\":\"\",\"disks\":[{\"deviceName\":\"persistent-disk-0\",\"index\":0,\"mode\":\"READ_WRITE\",\"type\":\"PERSISTENT\"}],\"hostname\":\"w-java.c.cloud-tam-playground.google.com.internal\",\"id\":3814142962647370202,\"image\":\"\",\"machineType\":\"projects/256228373853/machineTypes/n1-standard-1\",\"maintenanceEvent\":\"NONE\",\"networkInterfaces\":[{\"accessConfigs\":[{\"externalIp\":\"104.155.75.91\",\"type\":\"ONE_TO_ONE_NAT\"}],\"forwardedIps\":[],\"ip\":\"10.240.0.2\",\"network\":\"projects/256228373853/networks/default\"}],\"scheduling\":{\"automaticRestart\":\"TRUE\",\"onHostMaintenance\":\"MIGRATE\"},\"serviceAccounts\":{\"256228373853-compute@developer.gserviceaccount.com\":{\"aliases\":[\"default\"],\"email\":\"256228373853-compute@developer.gserviceaccount.com\",\"scopes\":[\"https://www.googleapis.com/auth/cloud.useraccounts.readonly\",\"https://www.googleapis.com/auth/devstorage.read_only\",\"https://www.googleapis.com/auth/logging.write\"]},\"default\":{\"aliases\":[\"default\"],\"email\":\"256228373853-compute@developer.gserviceaccount.com\",\"scopes\":[\"https://www.googleapis.com/auth/cloud.useraccounts.readonly\",\"https://www.googleapis.com/auth/devstorage.read_only\",\"https://www.googleapis.com/auth/logging.write\"]}},\"tags\":[],\"virtualClock\":{\"driftToken\":\"594915479120507179\"},\"zone\":\"projects/256228373853/zones/europe-west1-d\"},\"project\":{\"attributes\":{\"BATTLENET_API_KEY\":\"wmq2v5zwfjkyezskgdch5mbarzxtbvtb\",\"google-compute-default-region\":\"us-central1\",\"google-compute-default-zone\":\"us-central1-f\",\"sshKeys\":\"wallenius:ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDQ2jiNakyG9dpLCophB1KqEa8lEL0mcgNfFnC4eRUyoZ7cc4L9RPtUBOtn3+sJw5H1l091paZOCcl+5QzEq+wsxYYOIZGAJ9SAVlyhxShOma739qwOEy5uzmp2CGHnlbnOd8IWlbFMwmF7qufdD8cgoPgS9aY2dSj93w28e+OqvwAjh7c5C6ElKrBQljrNJj0u3fz5FMKuZb6KbU9/C02HKsKVrXDJ9dOD+h0RSMcnXHOMhccT+WQBsrxAtsvxVyX78HL/uGnG3Hbone/fzE0O64Dq0OFNfwHTFURd6c5jkXnGEStkIpA7hwzb1QLoqyZ/YfPzI1CfjxQbxCcjEqXV google-ssh {\\\"userName\\\":\\\"wallenius@google.com\\\",\\\"expireOn\\\":\\\"2015-10-21T12:25:16+0000\\\"}\\nwallenius:ecdsa-sha2-nistp256 AAAAE2VjZHNhLXNoYTItbmlzdHAyNTYAAAAIbmlzdHAyNTYAAABBBJIBXaRBvsGkoEp93smAGeFKaZdUvdbKc8GkBzyBL1md98fJ0PQgDXXRWQ4L8gTZC4p3ZfcGypWtzptlePH0qi8= google-ssh {\\\"userName\\\":\\\"wallenius@google.com\\\",\\\"expireOn\\\":\\\"2015-10-21T12:25:05+0000\\\"}\\nwallenius:ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDduB5bRjM9Eqn7UcG6esTm2UWOMjXg5Jr07VLkTUMapt2k+ptPps2VA9P2lodHLdUikc05qj1P2DIY35HCHY+JQVVCK+BTd6/U7xzAcwQpiGrBn809yIt155GeuCz39f6SsuBupal/6ig5eNl+PAnEYLuU9Yziqy+oKb5a19nZ/HGc2399u+XnFMg3olvSO/LkNY5lQYDZyWQhvSv5bAMYobDR06O3L5SVgw3MA1WCaYd73B7NGOyHrKzqKlM/4HiEt5XkGpXD+rGHD9+/f+PpeGMDqVe9ffwHGQ3NLgwWbCgVEwt4N1yUC+jZL0IohBKDUOjDIlrIWQ9QV9QCV1lL wallenius@wallenius-macbookair.roam.corp.google.com\\nwallenius:ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCb7detiTAQosQ6Xmyc8jiKrEB3SNV2iA0rhNEwgbk+XXZ7WCkmEFcB/wRbgO5d3LK+i4M87hYqMx0Zslq243RQPi/syk1ZTvY9JvZ/M3mywNgrjLgHx4SnykuP6h62mZLLWxVZyrMr37hXVEPg66jausnQKlvXqRLVWMkp0Iyu/BucOf0ztv4m8lAqvfsjJESLqjOxNZQhzpi8EEowaIM+Isl+9Qcuu3iVkUfjJc8POBzc0prHzTECtSEPI9nzKBtON4WbNSEn4uzlAD8raIPNhciJNUGVaAStd1BGhiITme2F6t2MlieMJrKIeWpIrDgJlBEmHhPcxPMwvV4FAPQ5 wallenius@ninja.lul.corp.google.com\\nwushilin:ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDmTlA/XIeTGM2vGQezUYcfHec5mUrbXPV9pdxX+tVQOiO8B9NZg18eSnfIoUrdYVJx5z4OqZKYPKVC+1AwnKGcsK4fGK4UdnaP5QNLthXz1nb/BonSBsxOuzVP0upFWXm81A1IU29l1XbFDLWfcgYptMFthDsvYcfKuk4IMCvC34EIBrG/k6qHZnxnHnKJFZS83FFr5UKPrvApJJS8sHiIVTN0kCXmG2KvDjuu+ZFBpze/fZPpZoM3zppPupwoaml8bxTwR7YPbP8xQcn7w4EkzYHUZxts1GkxGhQgT9uMZ2KqWZ0tccfaQN7Gwi8nC05gIucbbsLt/fz19sEf0ZOt wushilin@wushilin-macbookpro.roam.corp.google.com\\nwushilin:ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDKaHjKqbFnLTBNEEVabicCzuJ5AF4/ZOekf7GDwNZYmGG2JexvTaTb1OeWTMu0z0T94LxZbvOdSLHwgBZFHqOvi4mB6x6waOXcmBXDkscuoStos38aR96FrW50F/nx9eFuOno96XKW5ocFU6zKXc0TXYG+WLDf8kQTElKwQQ9b+Wx2LCH701SBiFBlWJ85NXZ8hsWIws1ES85Rm5NNZHZDuh+WNAoED5mBMpCBld/25Y9LRpUGZLgIXw+l/HuzQ1NXyqhYFSPd75OOMaPtbsnIfsagKl+2OnlqQn1ngpLu+5KmFHYuydSJSLiaMC8UYAzn5L5hRuzw5NUvtqKX5FWX wushilin@wushilin0-goo.sin.corp.google.com\\nricc:ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCZOUzTvRbUjuI+CJLb5GlH75xCncw4GOypmL6BrrO/wbrvxTiM8BSE3xvR69Ly8L1/muccSPsGp1XSw1IS99vpnCGwyUJEsyaVlyeOHVBEFAGAuYhAwbZjfTt6LV2EYqfFR7lPUKIJHYKFCQ+A28LML8WiFXHfZ1n8lXb4ZXDSXPmeVoga6kRCuZqbVxyZZazXfiAzMD0KtwPdTmnq1mUMHhPtDb1nRbAgg2BJ81ZfSFYR11BecMf8ByD0ZjxcoBEwA79UHlw6RBsti88feExp9C3KXrwxoky12I2zDHfbdxh1G9XJKBBzDfI/8CTQT+2jP1cRMDn1uS06B2kkP9JV ricc@ricc-macbookair.roam.corp.google.com\",\"stackdriver-agent-key\":\"METNXZ2OMXZ0ILBIXMIKW1OBZBDKGG6M\"},\"numericProjectId\":256228373853,\"projectId\":\"google.com:cloud-tam-playground\"}}";
    
    
    // All below is ugly and has to go away
    
    @Before
    public void beforeEach() {
        this.lastUrl = null;
        this.lastHeaders = null;
        this.mockResponse = null;
    }
    
    private String lastUrl;
    private Map<String, String> lastHeaders;
    private String mockResponse;

    @Override
    public String getRequest(String url, Map<String, String> headers) {
        this.lastUrl = url;
        this.lastHeaders = headers;
        return mockResponse;
    }

    @Override
    public String postRequest(String url, String postBody, Map<String, String> headers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
