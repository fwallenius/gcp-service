package com.google.cloud.wallenius.wallenius.gcp.beans;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Project {

    private Long numericProjectId;
    private String projectId;
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     *     
*/
    public Project() {
    }

    /**
     *
     * @param projectId
     * @param numericProjectId
     */
    public Project(Long numericProjectId, String projectId) {
        this.numericProjectId = numericProjectId;
        this.projectId = projectId;
    }

    public Long getNumericProjectId() {
        return numericProjectId;
    }

    public void setNumericProjectId(Long numericProjectId) {
        this.numericProjectId = numericProjectId;
    }

    /**
     *
     * @return The projectId
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     *
     * @param projectId The projectId
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Project{" + "numericProjectId=" + numericProjectId + ", projectId=" + projectId + ", additionalProperties=" + additionalProperties + '}';
    }
    
    

}
