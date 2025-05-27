/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkinglot.repositories;
import com.mycompany.parkinglot.models.Gate;
import java.util.Map;

import java.util.Optional;
import java.util.TreeMap;


public class GateRepository {
    //Intimidating database
    private Map<Integer, Gate> gates = new TreeMap<>(); //TC will be O(log N) coz of TreeMap functionality
    public Optional<Gate> findGateById(int gateId){    // Optional<T> conveys that the objec can return null, make sure you do null check 
        if(gates.containsKey(gateId)){
            return Optional.of(gates.get(gateId));
        }
        
        return Optional.empty();
    }
}
//database: might give the data in the form of JSON or String
//For such things we have ORM: Object-Relational Mapping which helps you to convert data into the corresponding
//objects and corresponding objects into the data also. One such ORM is Hibernate
