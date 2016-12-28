/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.model;

import org.springframework.stereotype.Service;

/**
 *
 * @author Tharindu Jayathilake
 */
@Service
public class PredefinedServices {

    private String serviceId;
    private String facilitatorId;
    private String serviceName;
    private String description;

    public PredefinedServices() {
    }

    public PredefinedServices(String serviceId, String facilitatorId, String serviceName, String description) {
        this.serviceId = serviceId;
        this.facilitatorId = facilitatorId;
        this.serviceName = serviceName;
        this.description = description;
    }

    /**
     * @return the serviceId
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * @param serviceId the serviceId to set
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * @return the facilitatorId
     */
    public String getFacilitatorId() {
        return facilitatorId;
    }

    /**
     * @param facilitatorId the facilitatorId to set
     */
    public void setFacilitatorId(String facilitatorId) {
        this.facilitatorId = facilitatorId;
    }

    /**
     * @return the serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * @param serviceName the serviceName to set
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
