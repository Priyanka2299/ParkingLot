/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkinglot.repositories;
import com.mycompany.parkinglot.models.*;
import com.mycompany.parkinglot.strategies.*;

import java.util.ArrayList;


import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 *
 * @author EMF
 */
public class ParkingLotRepository {
    private Map<Integer, ParkingLot> parkingLots = new TreeMap<>();
    
    public ParkingLotRepository(){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(1);
        parkingLot.setSlotAssignmentStrategyType(SlotAssignmentStrategyType.RANDOM);
        
        parkingLots.put(1, parkingLot);
        
    }
    public Optional<ParkingLot> findById(int id){
        if(parkingLots.containsKey(id)){
            return Optional.of(parkingLots.get(id));
        }
        return Optional.empty();
    }
}
