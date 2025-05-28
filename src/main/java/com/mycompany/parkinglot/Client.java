/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parkinglot;

import com.mycompany.parkinglot.controllers.TicketController;
import com.mycompany.parkinglot.dtos.IssueTicketRequestDTO;
import com.mycompany.parkinglot.dtos.IssueTicketResponseDTO;
import com.mycompany.parkinglot.repositories.*;
import com.mycompany.parkinglot.services.TicketService;
import com.mycompany.parkinglot.models.*;
/**
 *
 * @author EMF
 */
public class Client {

    public static void main(String[] args) {
        //Call the ocnstructor -> create controller object -> create service object -> create repositories object
        TicketRepository ticketRepository = new TicketRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        
        TicketService ticketService = new TicketService(
            gateRepository,
            vehicleRepository,
            parkingLotRepository,
            ticketRepository);
        
        TicketController ticketController = new TicketController(ticketService);
        
        IssueTicketRequestDTO issueTicketRequestDTO = new IssueTicketRequestDTO();
        issueTicketRequestDTO.setOwnerName("Priyanka");
        issueTicketRequestDTO.setParkingLotId(1);
        issueTicketRequestDTO.setGateId(1);
        issueTicketRequestDTO.setVehicleNumber("DLVC0001");
        issueTicketRequestDTO.setVehicleType(VehicleType.THREE_WHEELER);
        
        IssueTicketResponseDTO responseDTO = ticketController.issueTicket(issueTicketRequestDTO);
        System.out.println(responseDTO.getMessage());
        System.out.println(responseDTO.getTicket().getNumber());
    }
}
//Controller: TicketController -> main functionality issuingTicket