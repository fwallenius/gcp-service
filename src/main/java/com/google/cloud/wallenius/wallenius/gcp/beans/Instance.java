package com.google.cloud.wallenius.wallenius.gcp.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Instance {

    private String cpuPlatform;
    private String description;
    private List<Disk> disks = new ArrayList<>();
    private String hostname;
    private Long id;
    private String image;
    private String machineType;
    private String maintenanceEvent;
    private List<NetworkInterface> networkInterfaces = new ArrayList<NetworkInterface>();
    private Scheduling scheduling;
    private List<String> tags = new ArrayList<>();
    private String zone;
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     *     
*/
    public Instance() {
    }

    /**
     *
     * @param tags
     * @param scheduling
     * @param id
     * @param cpuPlatform
     * @param networkInterfaces
     * @param machineType
     * @param description
     * @param image
     * @param hostname
     * @param maintenanceEvent
     * @param disks
     * @param zone
     */
    public Instance(String cpuPlatform, String description, List<Disk> disks, String hostname, Long id, String image, String machineType, String maintenanceEvent, List<NetworkInterface> networkInterfaces, Scheduling scheduling, List<String> tags, String zone) {
        this.cpuPlatform = cpuPlatform;
        this.description = description;
        this.disks = disks;
        this.hostname = hostname;
        this.id = id;
        this.image = image;
        this.machineType = machineType;
        this.maintenanceEvent = maintenanceEvent;
        this.networkInterfaces = networkInterfaces;
        this.scheduling = scheduling;
        this.tags = tags;
        this.zone = zone;
    }

    /**
     *
     * @return The cpuPlatform
     */
    public String getCpuPlatform() {
        return cpuPlatform;
    }

    /**
     *
     * @param cpuPlatform The cpuPlatform
     */
    public void setCpuPlatform(String cpuPlatform) {
        this.cpuPlatform = cpuPlatform;
    }

    /**
     *
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return The disks
     */
    public List<Disk> getDisks() {
        return disks;
    }

    /**
     *
     * @param disks The disks
     */
    public void setDisks(List<Disk> disks) {
        this.disks = disks;
    }

    /**
     *
     * @return The hostname
     */
    public String getHostname() {
        return hostname;
    }

    /**
     *
     * @param hostname The hostname
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    

    /**
     *
     * @return The image
     */
    public String getImage() {
        return image;
    }

    /**
     *
     * @param image The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     *
     * @return The machineType
     */
    public String getMachineType() {
        return machineType;
    }

    /**
     *
     * @param machineType The machineType
     */
    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    /**
     *
     * @return The maintenanceEvent
     */
    public String getMaintenanceEvent() {
        return maintenanceEvent;
    }

    /**
     *
     * @param maintenanceEvent The maintenanceEvent
     */
    public void setMaintenanceEvent(String maintenanceEvent) {
        this.maintenanceEvent = maintenanceEvent;
    }

    /**
     *
     * @return The networkInterfaces
     */
    public List<NetworkInterface> getNetworkInterfaces() {
        return networkInterfaces;
    }

    /**
     *
     * @param networkInterfaces The networkInterfaces
     */
    public void setNetworkInterfaces(List<NetworkInterface> networkInterfaces) {
        this.networkInterfaces = networkInterfaces;
    }

    /**
     *
     * @return The scheduling
     */
    public Scheduling getScheduling() {
        return scheduling;
    }

    /**
     *
     * @param scheduling The scheduling
     */
    public void setScheduling(Scheduling scheduling) {
        this.scheduling = scheduling;
    }

    /**
     *
     * @return The tags
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     *
     * @param tags The tags
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     *
     * @return The zone
     */
    public String getZone() {
        return zone;
    }

    /**
     *
     * @param zone The zone
     */
    public void setZone(String zone) {
        this.zone = zone;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Instance{" + "cpuPlatform=" + cpuPlatform + ", description=" + description + ", disks=" + disks + ", hostname=" + hostname + ", id=" + id + ", image=" + image + ", machineType=" + machineType + ", maintenanceEvent=" + maintenanceEvent + ", networkInterfaces=" + networkInterfaces + ", scheduling=" + scheduling + ", tags=" + tags + ", zone=" + zone + ", additionalProperties=" + additionalProperties + '}';
    }
    
    
}
