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
public class Equipment {
    private String equipmentId;
    private String facilitatorId;
    private String equipmentName;
    private String equipmentDescription;
    private String manufacturer;
    private int qoh;
    private String purchasedDate;

    public Equipment() {
    }

    public Equipment(String equipmentId, String facilitatorId, String equipmentName, String equipmentDescription, String manufacturer, int qoh, String purchasedDate) {
        this.equipmentId = equipmentId;
        this.facilitatorId = facilitatorId;
        this.equipmentName = equipmentName;
        this.equipmentDescription = equipmentDescription;
        this.manufacturer = manufacturer;
        this.qoh = qoh;
        this.purchasedDate = purchasedDate;
    }

    /**
     * @return the equipmentId
     */
    public String getEquipmentId() {
        return equipmentId;
    }

    /**
     * @param equipmentId the equipmentId to set
     */
    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
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
     * @return the equipmentName
     */
    public String getEquipmentName() {
        return equipmentName;
    }

    /**
     * @param equipmentName the equipmentName to set
     */
    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    /**
     * @return the equipmentDescription
     */
    public String getEquipmentDescription() {
        return equipmentDescription;
    }

    /**
     * @param equipmentDescription the equipmentDescription to set
     */
    public void setEquipmentDescription(String equipmentDescription) {
        this.equipmentDescription = equipmentDescription;
    }

    /**
     * @return the manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * @param manufacturer the manufacturer to set
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * @return the qoh
     */
    public int getQoh() {
        return qoh;
    }

    /**
     * @param qoh the qoh to set
     */
    public void setQoh(int qoh) {
        this.qoh = qoh;
    }

    /**
     * @return the purchasedDate
     */
    public String getPurchasedDate() {
        return purchasedDate;
    }

    /**
     * @param purchasedDate the purchasedDate to set
     */
    public void setPurchasedDate(String purchasedDate) {
        this.purchasedDate = purchasedDate;
    }
}
