/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkinglot.strategies;

import com.mycompany.parkinglot.models.ParkingLot;
import com.mycompany.parkinglot.models.ParkingSlot;
import com.mycompany.parkinglot.models.VehicleType;
import java.util.Optional;

/**
 *
 * @author EMF
 */
public interface SlotAssignmentStrategy {
    public Optional<ParkingSlot> assignSlot(ParkingLot parkingLot, VehicleType vehicleType);
    
     
}
