/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkinglot.dtos;

import com.mycompany.parkinglot.models.VehicleType;

/**
 *
 * @author EMF
 */
public class IssueTicketRequestDTO {
    private int gateId;
    private String vehicleNUmber;
    private String ownerName;
    private VehicleType vehicleType;

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public String getVehicleNUmber() {
        return vehicleNUmber;
    }

    public void setVehicleNUmber(String vehicleNUmber) {
        this.vehicleNUmber = vehicleNUmber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
    
    
}
