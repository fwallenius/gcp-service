package com.google.cloud.wallenius.wallenius.gcp.beans;

import com.google.cloud.wallenius.wallenius.gcp.App;

/**
 *
 * @author wallenius
 */
public class HealthCheck {

    private Integer id;
    private Long uptime_ms;
    private final String version;

    public HealthCheck(Integer id, Long uptime_ms) {
        this.id = id;
        this.uptime_ms = uptime_ms;
        this.version = App.VERSION;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUptime_ms() {
        return uptime_ms;
    }

    public void setUptime_ms(Long uptime_ms) {
        this.uptime_ms = uptime_ms;
    }

    public String getVersion() {
        return version;
    }
    
}
