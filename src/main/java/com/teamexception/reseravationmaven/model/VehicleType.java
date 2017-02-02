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
public class VehicleType {

    private String typeId;
    private String vehicleName;

    public VehicleType() {
    }

    public VehicleType(String typeId, String vehicleName) {
        this.typeId = typeId;
        this.vehicleName = vehicleName;
    }

    /**
     * @return the typeId
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * @param typeId the typeId to set
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    /**
     * @return the vehicleName
     */
    public String getVehicleName() {
        return vehicleName;
    }

    /**
     * @param vehicleName the vehicleName to set
     */
    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    
}
