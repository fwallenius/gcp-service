package com.google.cloud.wallenius.wallenius.gcp.beans;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Scheduling {

    private String automaticRestart;
    private String onHostMaintenance;
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     *     
*/
    public Scheduling() {
    }

    /**
     *
     * @param automaticRestart
     * @param onHostMaintenance
     */
    public Scheduling(String automaticRestart, String onHostMaintenance) {
        this.automaticRestart = automaticRestart;
        this.onHostMaintenance = onHostMaintenance;
    }

    /**
     *
     * @return The automaticRestart
     */
    public String getAutomaticRestart() {
        return automaticRestart;
    }

    /**
     *
     * @param automaticRestart The automaticRestart
     */
    public void setAutomaticRestart(String automaticRestart) {
        this.automaticRestart = automaticRestart;
    }

    /**
     *
     * @return The onHostMaintenance
     */
    public String getOnHostMaintenance() {
        return onHostMaintenance;
    }

    /**
     *
     * @param onHostMaintenance The onHostMaintenance
     */
    public void setOnHostMaintenance(String onHostMaintenance) {
        this.onHostMaintenance = onHostMaintenance;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Scheduling{" + "automaticRestart=" + automaticRestart + ", onHostMaintenance=" + onHostMaintenance + ", additionalProperties=" + additionalProperties + '}';
    }
    
    
}
