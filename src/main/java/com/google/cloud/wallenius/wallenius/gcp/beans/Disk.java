package com.google.cloud.wallenius.wallenius.gcp.beans;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Disk {

    private String deviceName;
    private Integer index;
    private String mode;
    private String type;
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     *     
*/
    public Disk() {
    }

    /**
     *
     * @param index
     * @param deviceName
     * @param type
     * @param mode
     */
    public Disk(String deviceName, Integer index, String mode, String type) {
        this.deviceName = deviceName;
        this.index = index;
        this.mode = mode;
        this.type = type;
    }

    /**
     *
     * @return The deviceName
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     *
     * @param deviceName The deviceName
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     *
     * @return The index
     */
    public Integer getIndex() {
        return index;
    }

    /**
     *
     * @param index The index
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     *
     * @return The mode
     */
    public String getMode() {
        return mode;
    }

    /**
     *
     * @param mode The mode
     */
    public void setMode(String mode) {
        this.mode = mode;
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
        return "Disk{" + "deviceName=" + deviceName + ", index=" + index + ", mode=" + mode + ", type=" + type + ", additionalProperties=" + additionalProperties + '}';
    }

    
}
