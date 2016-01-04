package com.google.cloud.wallenius.wallenius.gcp.beans;

/**
 *
 * @author wallenius
 */
public class HealthCheck {

    private Integer id;
    private Long uptime_ms;

    public HealthCheck(Integer id, Long uptime_ms) {
        this.id = id;
        this.uptime_ms = uptime_ms;
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
    
    
    
}
