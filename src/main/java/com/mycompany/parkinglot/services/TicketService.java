/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkinglot.services;
import com.mycompany.parkinglot.models.Ticket;
import com.mycompany.parkinglot.models.VehicleType;
import com.mycompany.parkinglot.repositories.GateRepository;
import com.mycompany.parkinglot.models.Gate;
import com.mycompany.parkinglot.models.Vehicle;
import com.mycompany.parkinglot.repositories.ParkingLotRepository;
import com.mycompany.parkinglot.repositories.VehicleRepository;
import com.mycompany.parkinglot.models.ParkingLot;
import com.mycompany.parkinglot.models.ParkingSlot;
import com.mycompany.parkinglot.strategies.SlotAssignmentStrategyFactory;
import com.mycompany.parkinglot.models.*;
import com.mycompany.parkinglot.repositories.TicketRepository;
import java.util.Date;



import java.util.Optional;
 
public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;
    
    public TicketService(
            GateRepository gateRepository,
            VehicleRepository vehicleRepository,
            TicketRepository ticketRepository
    ){
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }
    
    public Ticket issueTicket(
            String vehicleNumber,
            String ownerName,
            VehicleType vehicleType,
            int gateId,
            int parkingLotId){
            
//        1.Get the corresponding Gate object for gateId
            Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
            if(gateOptional.isEmpty()){
                throw new RuntimeException("Invalid Gate Found");
            }
            Gate gate = gateOptional.get();
            
//        2. Get the corresponding vehicle Object
            Optional<Vehicle> vehicleOptional = vehicleRepository.findByVehicleNumber(vehicleNumber);
            
//        3.If vehicle doesn't already create one object
            Vehicle vehicle = null;
            if(vehicleOptional.isEmpty()){
                vehicle = new Vehicle();
                vehicle.setVehicleType(vehicleType);
                vehicle.setOwnerName(ownerName);
                vehicle.setLicenseNumber(vehicle.getLicenseNumber());
                vehicle = vehicleRepository.save(vehicle);
            }else{
                vehicle = vehicleOptional.get();
            }
//        4.Assign Slot
            Optional<ParkingLot> parkingLotOptional = parkingLotRepository.findById(parkingLotId);
                if(parkingLotOptional.isEmpty()){
                    throw new RuntimeException("Invalid ParkingLot Found");
                }
                ParkingLot parkingLot = parkingLotOptional.get();
            Optional <ParkingSlot> parkingSlotOptional = SlotAssignmentStrategyFactory
                    .getSlotAssignmentStrategyByType(parkingLot.getSlotAssignmentStrategyType())
                    .assignSlot(parkingLot, vehicleType);
            
//        5. ticket object creation
            Ticket ticket = new Ticket();
            ticket.setVehicle(vehicle);
            ticket.setGate(gate);
            ticket.setOperator(gate.getOperator());
            ticket.setEntryTime(new Date());
            ticket.setParkingSlot(parkingSlotOptional.get());
//        6. save ticket object in the database
            



        
        return ticketRepository.save(ticket);
    }
}
