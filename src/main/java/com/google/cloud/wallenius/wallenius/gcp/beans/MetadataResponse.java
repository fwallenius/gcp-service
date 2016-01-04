package com.google.cloud.wallenius.wallenius.gcp.beans;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class MetadataResponse {

    private Instance instance;
    private Project project;
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     *     
*/
    public MetadataResponse() {
    }

    /**
     *
     * @param project
     * @param instance
     */
    public MetadataResponse(Instance instance, Project project) {
        this.instance = instance;
        this.project = project;
    }

    /**
     *
     * @return The instance
     */
    public Instance getInstance() {
        return instance;
    }

    /**
     *
     * @param instance The instance
     */
    public void setInstance(Instance instance) {
        this.instance = instance;
    }

    /**
     *
     * @return The project
     */
    public Project getProject() {
        return project;
    }

    /**
     *
     * @param project The project
     */
    public void setProject(Project project) {
        this.project = project;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "MetadataResponse{" + "instance=" + instance + ", project=" + project + ", additionalProperties=" + additionalProperties + '}';
    }

    
}
