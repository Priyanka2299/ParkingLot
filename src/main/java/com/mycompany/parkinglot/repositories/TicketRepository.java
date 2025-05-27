/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkinglot.repositories;
import com.mycompany.parkinglot.models.Ticket;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author EMF
 */
public class TicketRepository {
    private Map<Integer, Ticket> tickets = new TreeMap<>();
    private static int previousId = 0;
    public Ticket save(Ticket ticket){        //since saving to a db require an id which is created automatically Instead we can use counter
        ticket.setId(previousId++);
        tickets.put(ticket.getId(), ticket);
        return ticket;
    }
}
