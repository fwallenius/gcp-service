package com.google.cloud.wallenius.wallenius.gcp.httpclient;

/**
 *
 * @author wallenius
 */
public class HttpException extends RuntimeException{
    
    public HttpException(Throwable ex) {
        super(ex);
    }
}
