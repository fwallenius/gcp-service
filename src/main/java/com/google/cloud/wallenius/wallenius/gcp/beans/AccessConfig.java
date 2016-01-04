package com.google.cloud.wallenius.wallenius.gcp.beans;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class AccessConfig {

    private String externalIp;
    private String type;
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     *     
*/
    public AccessConfig() {
    }

    /**
     *
     * @param externalIp
     * @param type
     */
    public AccessConfig(String externalIp, String type) {
        this.externalIp = externalIp;
        this.type = type;
    }

    /**
     *
     * @return The externalIp
     */
    public String getExternalIp() {
        return externalIp;
    }

    /**
     *
     * @param externalIp The externalIp
     */
    public void setExternalIp(String externalIp) {
        this.externalIp = externalIp;
    }

    /**
     *
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "AccessConfig{" + "externalIp=" + externalIp + ", type=" + type + ", additionalProperties=" + additionalProperties + '}';
    }
    
    
}
