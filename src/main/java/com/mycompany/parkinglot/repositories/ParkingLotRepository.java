/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkinglot.repositories;
import com.mycompany.parkinglot.models.ParkingLot;


import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 *
 * @author EMF
 */
public class ParkingLotRepository {
    private Map<Integer, ParkingLot> parkingLots = new TreeMap<>();
    public Optional<ParkingLot> findById(int id){
        if(parkingLots.containsKey(id)){
            return Optional.of(parkingLots.get(id));
        }
        return Optional.empty();
    }
}
