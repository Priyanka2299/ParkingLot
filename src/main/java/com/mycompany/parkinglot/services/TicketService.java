/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkinglot.services;
import com.mycompany.parkinglot.models.Ticket;
import com.mycompany.parkinglot.models.VehicleType;
import com.mycompany.parkinglot.repositories.GateRepository;
import com.mycompany.parkinglot.models.Gate;

import java.util.Optional;
 
public class TicketService {
    private GateRepository gateRepository;
    
    
    public Ticket issueTicket(
            String vehicleNumber,
            String ownerName,
            VehicleType vehicleType,
            int gateId){
            
//        1.Get the corresponding Gate object for gateId
            Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
            if(gateOptional.isEmpty()){
                throw new RuntimeException("Invalid Gate Found");
            }
            Gate gate = gateOptional.get();
//        2. Get the corresponding vehicle Object
//        3.If vehicle doesn't already create one object
//        4.Assign Slot
//        5. ticket object creation
//        6. save ticket object in the database



        
        return null;
    }
}
