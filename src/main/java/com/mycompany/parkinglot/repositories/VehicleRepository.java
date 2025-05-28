/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkinglot.repositories;
import com.mycompany.parkinglot.models.*;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 *
 * @author EMF
 */
public class VehicleRepository {
    private Map<String, Vehicle> vehicles = new TreeMap<>();
    

    private static int previousId =0;
//    vehicle# is same as license#
    public Optional<Vehicle> findByVehicleNumber(String licenseNumber){
        if(vehicles.containsKey(licenseNumber)){
            return Optional.of(vehicles.get(licenseNumber));
        }
        return Optional.empty();
    }
    public Vehicle save(Vehicle vehicle){
        previousId++;
        vehicle.setId(previousId);
        vehicles.put(vehicle.getLicenseNumber(), vehicle);
        return vehicle;
    }

}
