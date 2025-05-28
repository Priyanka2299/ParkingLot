/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkinglot.controllers;

import com.mycompany.parkinglot.dtos.IssueTicketRequestDTO;
import com.mycompany.parkinglot.dtos.IssueTicketResponseDTO;
import com.mycompany.parkinglot.dtos.ResponseStatus;
import com.mycompany.parkinglot.models.VehicleType;
import com.mycompany.parkinglot.services.TicketService;
import com.mycompany.parkinglot.models.Ticket;

/**
 *
 * @author EMF
 */
public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    
    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO request){
        IssueTicketResponseDTO response = new IssueTicketResponseDTO();
        try {
            Ticket ticket = ticketService.issueTicket(
            request.getVehicleNUmber(),
            request.getOwnerName(),
            request.getVehicleType(),
            request.getGateId(),
            request.getParkingLotId()
            );
            response.setTicket(ticket);
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setMessage("Ticket Generated Successfully");
            
        }catch(Exception ex){
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setMessage(ex.getMessage());
        }
        return response;
    }
}

//DTO: Data transfer Object: used to transfer data between different layers of an application, 
//especially between the client and server or between the controller and service layers,
//incase the client gives data in the form of JSON(object)
