/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkinglot.strategies;

import com.mycompany.parkinglot.models.ParkingFloor;
import com.mycompany.parkinglot.models.ParkingLot;
import com.mycompany.parkinglot.models.ParkingSlot;
import com.mycompany.parkinglot.models.ParkingSlotStatus;
import com.mycompany.parkinglot.models.VehicleType;

/**
 *
 * @author EMF
 */
public class RandomSlotAssignmentStrategy implements SlotAssignmentStrategy{
    @Override
    public ParkingSlot assignSlot(ParkingLot parkingLot, VehicleType vehicleType){
        for(ParkingFloor parkingFloor: parkingLot.getParkingFloors()){
            for(ParkingSlot parkingSlot: parkingFloor.getParkingSlots()){
                if(parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.EMPTY)
                        && parkingSlot.getVehicleType().equals(vehicleType)){
                    return parkingSlot;
                }
            }
        }
        return null;
    
    }
}
