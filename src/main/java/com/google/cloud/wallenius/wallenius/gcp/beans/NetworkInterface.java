package com.google.cloud.wallenius.wallenius.gcp.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class NetworkInterface {

    private List<AccessConfig> accessConfigs = new ArrayList<>();
    private String ip;
    private String network;
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     *     
*/
    public NetworkInterface() {
    }

    /**
     *
     * @param network
     * @param ip
     * @param accessConfigs
     */
    public NetworkInterface(List<AccessConfig> accessConfigs, String ip, String network) {
        this.accessConfigs = accessConfigs;
        this.ip = ip;
        this.network = network;
    }

    /**
     *
     * @return The accessConfigs
     */
    public List<AccessConfig> getAccessConfigs() {
        return accessConfigs;
    }

    /**
     *
     * @param accessConfigs The accessConfigs
     */
    public void setAccessConfigs(List<AccessConfig> accessConfigs) {
        this.accessConfigs = accessConfigs;
    }

    /**
     *
     * @return The ip
     */
    public String getIp() {
        return ip;
    }

    /**
     *
     * @param ip The ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     *
     * @return The network
     */
    public String getNetwork() {
        return network;
    }

    /**
     *
     * @param network The network
     */
    public void setNetwork(String network) {
        this.network = network;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "NetworkInterface{" + "accessConfigs=" + accessConfigs + ", ip=" + ip + ", network=" + network + ", additionalProperties=" + additionalProperties + '}';
    }
    
    
}
